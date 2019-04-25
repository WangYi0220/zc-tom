package com.zc.tom.service;

import com.zc.tom.common.utils.SpringUtils;
import com.zc.tom.mapper.StatisticsMapper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/24 10:40
 * @description：
 * @modified By：
 */
@Service
@Transactional
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private StatisticsMapper statisticsMapper;
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 工资统计
     *
     * @param classUUID
     * @return
     */
    @Override
    public ResponseEntity<InputStreamResource> statistics(String classUUID) {
        ResponseEntity<InputStreamResource> response = null;
        try {
            List<Map<String, Object>> statistics = statisticsMapper.statistics(classUUID);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet xssfSheet = workbook.createSheet();
            XSSFRow titleRow = xssfSheet.createRow(0);
            titleRow.createCell(0).setCellValue("学生姓名");
            titleRow.createCell(1).setCellValue("学生等级");
            titleRow.createCell(2).setCellValue("基本工资");
            titleRow.createCell(3).setCellValue("岗位津贴");
            titleRow.createCell(4).setCellValue("赏罚金额");
            titleRow.createCell(5).setCellValue("绩效系数");
            titleRow.createCell(6).setCellValue("考核分数");
            titleRow.createCell(7).setCellValue("考核工资");
            titleRow.createCell(8).setCellValue("当前积分");
            titleRow.createCell(9).setCellValue("实发工资");
            statistics.forEach(item -> {
                System.out.println(item);
                int lastRowNum = xssfSheet.getLastRowNum();
                XSSFRow dataRow = xssfSheet.createRow(lastRowNum + 1);
                String stuName = (String) item.get("stuName");//学生姓名
                String levelName = (String) item.get("levelName");//学生等级
                Double salary = Double.parseDouble(item.get("salary").toString());//基本工资
                Double subsidyTotal = Double.parseDouble(item.get("subsidyTotal").toString());//岗位津贴
                Double moneyTotal = Double.parseDouble(item.get("moneyTotal").toString());//赏罚金额
                Integer valueTotal = Integer.parseInt(item.get("valueTotal").toString());//当前积分
                Double coefficient = Double.parseDouble(item.get("coefficient").toString());//绩效系数
                Double score = Double.parseDouble(item.get("score").toString());//考核分数
                Double checkWage = (salary * coefficient * score);//考核工资
                ConcurrentHashMap<String, Object> content = new ConcurrentHashMap<>();
                content.put("stuName", stuName);
                content.put("levelName", levelName);
                content.put("salary", ((salary + 0.00) / 100.00));
                content.put("subsidyTotal", ((subsidyTotal + 0.00) / 100.00));
                content.put("moneyTotal", ((moneyTotal + 0.00) / 100.00));
                content.put("coefficient", (coefficient + 0.00) / 100.00);
                content.put("score", score);
                content.put("checkWage", (checkWage + 0.00) / Math.pow(100.00, 3.00));
                content.put("valueTotal", valueTotal);
                content.put("total", (salary + subsidyTotal + moneyTotal) / 100.00 + (checkWage + 0.00) / Math.pow(100.00, 3.00));
                dataRow.createCell(0).setCellValue(stuName);//学生姓名
                dataRow.createCell(1).setCellValue(levelName);//学生等级
                dataRow.createCell(2).setCellValue(((salary + 0.00) / 100.00));//基本工资
                dataRow.createCell(3).setCellValue(((subsidyTotal + 0.00) / 100.00));//岗位津贴
                dataRow.createCell(4).setCellValue(((moneyTotal + 0.00) / 100.00));//赏罚金额
                dataRow.createCell(5).setCellValue((coefficient + 0.00) / 100.00);//绩效系数
                dataRow.createCell(6).setCellValue(score);//考核分数
                dataRow.createCell(7).setCellValue((checkWage + 0.00) / Math.pow(100.00, 3.00));//考核工资
                dataRow.createCell(8).setCellValue(valueTotal);//当前积分
                dataRow.createCell(9).setCellValue((salary + subsidyTotal + moneyTotal) / 100.00 + (checkWage + 0.00) / Math.pow(100.00, 3.00));//实发工资
                StatisticsService statisticsService = SpringUtils.getBean(StatisticsService.class);
                statisticsService.sendEmailToStudent(item.get("email").toString(), content);
            });
            String fileName = "工资汇总.xlsx";
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            //将excel文件写入输出流
            workbook.write(out);
            workbook.close();
            InputStream excelStream = new ByteArrayInputStream(out.toByteArray());
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("gbk"), "iso8859-1"));
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            response = ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType("application/octet-stream")).body(new InputStreamResource(excelStream));
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 工资统计前，检查哪一个学生没有给考核分数
     *
     * @param classUUID
     * @return
     */
    @Override
    public List<String> checkIn(String classUUID) {
        List<String> names = new ArrayList<>();
        List<Map<String, Object>> list = statisticsMapper.checkIn(classUUID);
        list.forEach(item -> {
            String score = item.get("score").toString();
            if ("-1".equals(score.trim())) names.add(item.get("stuName").toString());
        });
        return names;
    }

    /**
     * 给学生发送邮件
     *
     * @param email
     */
    @Override
    @Async
    public void sendEmailToStudent(String email, Map<String, Object> content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        String text = "姓名：" + content.get("stuName")
                + "<br/>等级：" + content.get("levelName")
                + "<br/>基本工资：" + content.get("salary")
                + "<br/>岗位津贴：" + content.get("subsidyTotal")
                + "<br/>赏罚金额：" + content.get("moneyTotal")
                + "<br/>考核系数：" + content.get("coefficient")
                + "<br/>考核分数：" + content.get("score")
                + "<br/>考核工资：" + content.get("checkWage")
                + "<br/>当前积分：" + content.get("valueTotal")
                + "<br/>总工资：" + content.get("total");
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject("专才教务处");
            helper.setText(text, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

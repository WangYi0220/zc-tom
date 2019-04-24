package com.zc.tom.service;

import com.zc.tom.mapper.StatisticsMapper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

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
}

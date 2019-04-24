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
     * @param classUUID
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ResponseEntity<InputStreamResource> statistics(String classUUID, String beginDate, String endDate) {
        ResponseEntity<InputStreamResource> response = null;
        try {
            List<Map<String, Object>> statistics = statisticsMapper.statistics(classUUID, beginDate, endDate);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet xssfSheet = workbook.createSheet();
            XSSFRow titleRow = xssfSheet.createRow(0);
            titleRow.createCell(0).setCellValue("学生姓名");
            titleRow.createCell(1).setCellValue("学生等级");
            titleRow.createCell(2).setCellValue("基本工资");
            titleRow.createCell(3).setCellValue("岗位津贴");
            titleRow.createCell(4).setCellValue("赏罚金额");
            titleRow.createCell(5).setCellValue("当前积分");
            titleRow.createCell(6).setCellValue("实发工资");
            statistics.forEach(item -> {
                System.out.println(item);
                int lastRowNum = xssfSheet.getLastRowNum();
                XSSFRow dataRow = xssfSheet.createRow(lastRowNum + 1);
                String stuName = (String) item.get("stuName");
                String levelName = (String) item.get("levelName");
                Double salary = Double.parseDouble(item.get("salary").toString());
                Double subsidyTotal = Double.parseDouble(item.get("subsidyTotal").toString());
                Double moneyTotal = Double.parseDouble(item.get("moneyTotal").toString());
                Integer valueTotal = Integer.parseInt(item.get("valueTotal").toString());
                dataRow.createCell(0).setCellValue(stuName);
                dataRow.createCell(1).setCellValue(levelName);
                dataRow.createCell(2).setCellValue((salary/100.00));
                dataRow.createCell(3).setCellValue((subsidyTotal/100.00));
                dataRow.createCell(4).setCellValue((moneyTotal/100.00));
                dataRow.createCell(5).setCellValue(valueTotal);
                dataRow.createCell(6).setCellValue(((salary+subsidyTotal+moneyTotal)/100.00));
            });
            String fileName = beginDate+"~"+endDate+"工资汇总.xlsx";
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

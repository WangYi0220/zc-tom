package com.zc.tom.service;

import com.zc.tom.common.utils.UUIDUtils;
import com.zc.tom.mapper.StudentMapper;
import com.zc.tom.pojo.Student;
import com.zc.tom.pojo.Teacher;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:41
 * @description：
 * @modified By：
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    //添加学生信息
    @Override
    public void importStudentInfo(MultipartFile multipartFile) {
        try {
            List<Student> teachers = new ArrayList<>();
            InputStream inputStream = multipartFile.getInputStream();
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheetAt = workbook.getSheetAt(0);
            for (Row row : sheetAt) {
                if (row.getRowNum() == 0 || row.getRowNum() == 1) {
                    continue;
                }
                //从excel文件中获取辅导员的信息
                String stuUUID = UUIDUtils.getUUID();//主键
                String stuName = row.getCell(0).getStringCellValue();//学生姓名
                row.getCell(1).setCellType(CellType.STRING);
                String stuNo = row.getCell(1).getStringCellValue();//学生学号
                row.getCell(2).setCellType(CellType.STRING);
                String className = row.getCell(2).getStringCellValue();//班级编号
                System.out.println(className+".................");
                String classUUID1 = studentMapper.queryClassUUIDByClassName(className);
                System.out.println(classUUID1+"111111111111");
                row.getCell(3).setCellType(CellType.STRING);
                String email = row.getCell(3).getStringCellValue();//邮箱

                teachers.add(new Student(stuUUID,stuName,stuNo,classUUID1,email));
            }
            teachers.forEach(System.out::println);
            studentMapper.addStudent(teachers);

            //return teacher;
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        //return null;
    }
}

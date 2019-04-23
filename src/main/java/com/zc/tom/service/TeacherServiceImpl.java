package com.zc.tom.service;

import com.zc.tom.common.utils.UUIDUtils;
import com.zc.tom.mapper.TeacherMapper;
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
 * @date ：Created in 2019/4/22 22:44
 * @description：
 * @modified By：
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    //查看辅导员信息列表
    @Override
    public List<Teacher> queryTeacherList() {
        return teacherMapper.queryTeacherList();
    }

    //导入辅导员信息
    @Override
    public void importTeacherInfo(MultipartFile multipartFile) {
        try {
            List<Teacher> teachers = new ArrayList<>();
            InputStream inputStream = multipartFile.getInputStream();
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheetAt = workbook.getSheetAt(0);
            for (Row row : sheetAt) {
                if (row.getRowNum() == 0 || row.getRowNum() == 1) {
                    continue;
                }
                //从excel文件中获取辅导员的信息
                String teaUUID = UUIDUtils.getUUID();
                String teaName = row.getCell(0).getStringCellValue();
                if ("".equals(teaName.trim())) continue;
                row.getCell(1).setCellType(CellType.STRING);
                String telephone = row.getCell(1).getStringCellValue();

                teachers.add(new Teacher(teaUUID,teaName,telephone,telephone));
            }
            teachers.forEach(System.out::println);
            teacherMapper.addTeacher(teachers);

            //return teacher;
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        //return null;
    }

    //禁用辅导员
    @Override
    public void deleteTeacherStatusByTeaUUID(String teaUUID) {
        teacherMapper.deleteTeacherStatusByTeaUUID(teaUUID);
    }
}

package com.zc.tom.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.tom.common.utils.UUIDUtils;
import com.zc.tom.mapper.StudentMapper;
import com.zc.tom.pojo.Student;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
import java.util.Map;

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

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 根据班级编号查看学生信息列表，实现分页
     *
     * @param classUUID
     * @param pageNum
     * @return
     */
    @Override
    public PageInfo<Map<String, Object>> queryStudentListByClassUUID(String classUUID, Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Map<String, Object>> students = studentMapper.queryStudentListByClassUUID(classUUID);
        return new PageInfo<>(students);
    }

    /**
     * 根据编号查看学生信息
     *
     * @param stuUUID
     * @return
     */
    @Override
    public Map<String, Object> queryStudentByStuUUID(String stuUUID) {
        return studentMapper.queryStudentByStuUUID(stuUUID);
    }

    /**
     * 修改学生信息
     *
     * @param student
     */
    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    /**
     * 添加学生信息
     *
     * @param multipartFile
     * @param classUUID
     */
    @Override
    public void importStudentInfo(MultipartFile multipartFile, String classUUID) {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        try {
            List<Student> students = new ArrayList<>();
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
                System.out.println(stuName);
                if ("".equals(stuName.trim())) continue;
                row.getCell(1).setCellType(CellType.STRING);
                String stuNo = row.getCell(1).getStringCellValue();//学生学号
                row.getCell(2).setCellType(CellType.STRING);
                String email = row.getCell(2).getStringCellValue();//邮箱
                students.add(new Student(stuUUID, stuName, stuNo, classUUID, email));
            }
            students.forEach(item -> {
                studentMapper.addStudent(item);
            });
            sqlSession.flushStatements();
            students.forEach(item -> {
                studentMapper.addStuPosition(item.getStuUUID());
            });
            sqlSession.flushStatements();
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * 禁用学生信息
     *
     * @param stuUUID
     */
    @Override
    public void updateStudentStatusByStuUUID(String stuUUID) {
        studentMapper.updateStudentStatusByStuUUID(stuUUID);
    }
}

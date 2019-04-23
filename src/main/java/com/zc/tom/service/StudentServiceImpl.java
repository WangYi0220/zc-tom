package com.zc.tom.service;

import com.zc.tom.mapper.StudentMapper;
import com.zc.tom.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    // 查看学生信息列表
    @Override
    public List<Map<String, Object>> queryStudentList() {
        return studentMapper.queryStudentList();
    }

    // 根据编号查看学生信息
    @Override
    public Map<String, Object> queryStudentByStuUUID(String stuUUID) {
        return studentMapper.queryStudentByStuUUID(stuUUID);
    }

    // 修改学生信息
    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    // 禁用学生信息
    @Override
    public void updateStudentStatusByStuUUID(String stuUUID) {
        studentMapper.updateStudentStatusByStuUUID(stuUUID);
    }
}

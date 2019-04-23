package com.zc.tom.service;

import com.zc.tom.pojo.Student;

import java.util.List;
import java.util.Map;
/**
 * @author lxl
 * @Date Created in 2019/4/23 18:53
 * @description 赏罚
 * @modified By:
 */
public interface StudentService {
    // 查看学生信息列表
    List<Map<String,Object>> queryStudentList();

    // 根据编号查看学生信息
    Map<String, Object> queryStudentByStuUUID(String stuUUID);

    // 修改学生信息
    void updateStudent(Student student);

    // 禁用学生
    void updateStudentStatusByStuUUID(String stuUUID);
}

package com.zc.tom.mapper;

import com.zc.tom.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lxl
 * @Date Created in 2019/4/23 18:26
 * @description 赏罚
 * @modified By:
 */
public interface StudentMapper {
    // 查看学生信息列表
    List<Map<String,Object>> queryStudentList();

    // 根据编号查看学生信息
    Map<String, Object> queryStudentByStuUUID(@Param("stuUUID") String stuUUID);

    // 修改学生信息
    void updateStudent(Student student);

    // 禁用学生
    void updateStudentStatusByStuUUID(@Param("stuUUID") String stuUUID);
}

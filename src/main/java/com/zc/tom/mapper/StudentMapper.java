package com.zc.tom.mapper;

import com.zc.tom.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 学生操作
 */

/**
 * @author lxl
 * @Date Created in 2019/4/23 18:26
 * @description 赏罚
 * @modified By:
 */
public interface StudentMapper {
    // 根据班级编号查看学生信息列表
    List<Map<String,Object>> queryStudentListByClassUUID(@Param("classUUID") String classUUID);

    // 根据编号查看学生信息
    Map<String, Object> queryStudentByStuUUID(@Param("stuUUID") String stuUUID);

    // 修改学生信息
    void updateStudent(Student student);

    // 禁用学生
    void updateStudentStatusByStuUUID(@Param("stuUUID") String stuUUID);
    //添加学生信息
    void addStudent(Student student);

    //添加学生职位表
    void addStuPosition(@Param("stuUUID") String stuUUID);

}

package com.zc.tom.mapper;

import com.zc.tom.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学生操作
 */
public interface StudentMapper {

    //添加学生信息
    void addStudent(@Param("students") List<Student> students);

    //根据classUUID查询班级编号
    String queryClassUUIDByClassName(@Param("className") String className);
}

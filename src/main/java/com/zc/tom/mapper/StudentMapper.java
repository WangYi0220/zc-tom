package com.zc.tom.mapper;

import com.zc.tom.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学生操作
 */
public interface StudentMapper {

    //添加学生信息
    void addStudent(Student student);

    //添加学生职位表
    void addStuPosition(@Param("stuUUID") String stuUUID);



}

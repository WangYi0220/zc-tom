package com.zc.tom.mapper;

import com.zc.tom.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lxl
 * @Date Created in 2019/4/23 8:56
 * @description 辅导员
 * @modified By:
 */
public interface TeacherMapper {
    //查看辅导员信息列表
    List<Teacher> queryTeacherList();

    //添加辅导员信息
    void addTeacher(@Param("teachers") List<Teacher> teachers);

    //禁用辅导员
    void updateTeacherStatusByTeaUUID(@Param("teaUUID") String teaUUID);
}

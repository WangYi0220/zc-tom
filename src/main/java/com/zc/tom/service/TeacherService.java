package com.zc.tom.service;

import com.zc.tom.pojo.Teacher;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author lxl
 * @Date Created in 2019/4/23 8:56
 * @description 辅导员
 * @modified By:
 */
public interface TeacherService {
    //查看辅导员信息列表
    List<Teacher> queryTeacherList();

    //导入辅导员信息
    void importTeacherInfo(MultipartFile multipartFile);

    //禁用辅导员
    void updateTeacherStatusByTeaUUID(String teaUUID);
}

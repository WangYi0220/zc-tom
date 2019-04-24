package com.zc.tom.service;


import com.github.pagehelper.PageInfo;
import com.zc.tom.pojo.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
/**
 * @author lxl
 * @Date Created in 2019/4/23 18:53
 * @description 赏罚
 * @modified By:
 */
public interface StudentService {
    //添加学生信息
    void importStudentInfo(MultipartFile multipartFile,String classUUID);
    // 根据班级编号查看学生信息列表,实现分页功能
    PageInfo<Map<String,Object>> queryStudentListByClassUUID(String classUUID, Integer pageNum);

    // 根据编号查看学生信息
    Map<String, Object> queryStudentByStuUUID(String stuUUID);

    // 修改学生信息
    void updateStudent(Student student);

    // 禁用学生
    void updateStudentStatusByStuUUID(String stuUUID);

}

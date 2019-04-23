package com.zc.tom.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

public interface StudentService {

    //添加学生信息
    void importStudentInfo(MultipartFile multipartFile,String classUUID);

}

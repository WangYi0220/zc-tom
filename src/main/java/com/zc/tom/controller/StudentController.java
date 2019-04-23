package com.zc.tom.controller;

import com.zc.tom.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ：xie yuan yang
 * @date ：Created in 2019/4/22 22:42
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/Student")
@Api(tags = {"学生操作（xyy）"})
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/import")
    @ApiOperation("学生信息导入")
    public Boolean importStudentInfo(MultipartFile multipartFile){
        studentService.importStudentInfo(multipartFile);
        return true;
    }
}

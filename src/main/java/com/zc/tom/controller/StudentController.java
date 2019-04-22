package com.zc.tom.controller;

import com.zc.tom.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:42
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    private StudentService studentService;
}

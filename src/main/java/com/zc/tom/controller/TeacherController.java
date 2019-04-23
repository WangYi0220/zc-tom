package com.zc.tom.controller;

import com.zc.tom.pojo.Result;
import com.zc.tom.pojo.Teacher;
import com.zc.tom.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:45
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/teacher")
@Api(tags = "辅导员信息操作接口(lxl)")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private Result result;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ApiOperation("查看辅导员信息列表")
    public List<Teacher> queryTeacherList(){
        return teacherService.queryTeacherList();
    }

    @RequestMapping(value = "/import",method = RequestMethod.POST)
    @ApiOperation("导入辅导员信息")
    public Result importTeacherInfo(MultipartFile multipartFile){
        teacherService.importTeacherInfo(multipartFile);
        return result;
    }

    @RequestMapping(value = "/delete/{teaUUID}",method = RequestMethod.GET)
    @ApiOperation("禁用辅导员")
    public Result deleteTeacherStatusByTeaUUID(@PathVariable("teaUUID") String teaUUID){
        teacherService.deleteTeacherStatusByTeaUUID(teaUUID);
        return result;
    }
}

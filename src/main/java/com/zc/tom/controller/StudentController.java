package com.zc.tom.controller;

import com.zc.tom.pojo.Result;
import com.zc.tom.pojo.Student;
import com.zc.tom.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:42
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/Student")
@Api(tags = "学生信息操作接口(lxl)")
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private Result result;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ApiOperation("查看学生信息列表")
    public List<Map<String, Object>> queryStudentList(){
        return studentService.queryStudentList();
    }

    @RequestMapping(value = "/get/{stuUUID}",method = RequestMethod.GET)
    @ApiOperation("根据编号查看学生信息列表")
    public Map<String, Object> queryStudentByStuUUID(@PathVariable("stuUUID") String stuUUID){
        return studentService.queryStudentByStuUUID(stuUUID);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuName",value = "学生姓名",paramType = "query"),
            @ApiImplicitParam(name = "classUUID",value = "班级编号",paramType = "query"),
            @ApiImplicitParam(name = "email",value = "邮箱",paramType = "query"),
            @ApiImplicitParam(name = "stuUUID",value = "学生编号",paramType = "query")
    })
    @ApiOperation("修改学生信息")
    public Result updateStudent(@ApiIgnore Student student){
        log.info(student.toString());
        studentService.updateStudent(student);
        return result;
    }

    @RequestMapping(value = "/delete/{stuUUID}",method = RequestMethod.GET)
    @ApiOperation("禁用学生信息")
    public Result updateStudentStatusByStuUUID(@PathVariable("stuUUID") String stuUUID){
        studentService.updateStudentStatusByStuUUID(stuUUID);
        return result;
    }
}

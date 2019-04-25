package com.zc.tom.controller;

import com.github.pagehelper.PageInfo;
import com.zc.tom.common.myAnnotation.Root;
import com.zc.tom.pojo.Clazz;
import com.zc.tom.pojo.Result;
import com.zc.tom.service.ClazzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * @author ：xie yuan yang
 * @date ：Created in 2019/4/22 22:22
 * @description：班级操作
 * @modified By：
 */
@Api(tags = {"班级操作(xyy)"})
@RestController
@RequestMapping("/class")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @Autowired
    private Result result;

    @ApiOperation("添加班级")
    @PostMapping("/add/class")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "grade",value = "届",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "className",value = "班级名称",dataType = "String" ,paramType = "query"),
            @ApiImplicitParam(name = "teaUUID",value = "辅导员编号",dataType = "String" ,paramType = "query")
    })
    @Root
    public Result insertClazz(@ApiIgnore Clazz clazz){
        return clazzService.insertClazz(clazz);
    }


    @ApiOperation("修改班级")
    @PostMapping("/update/class")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "classUUID",value = "班级编号",dataType = "String" ,paramType = "query"),
            @ApiImplicitParam(name = "grade",value = "届",dataType = "String" ,paramType = "query"),
            @ApiImplicitParam(name = "className",value = "班级名称",dataType = "String" ,paramType = "query"),
            @ApiImplicitParam(name = "teaUUID",value = "辅导员编号",dataType = "String" ,paramType = "query")
    })
    public Result updateClazz(@ApiIgnore Clazz clazz){
        return clazzService.updateClazz(clazz);
    }


    @ApiOperation("查询全部班级")
    @GetMapping("/query/class/{currentPage}")
    public PageInfo<Map<String, Object>> queryClass(@PathVariable("currentPage") int currentPage){
        return clazzService.queryClass(currentPage);
    }

    @ApiOperation("根据辅导员编号和届查询班级")
    @GetMapping("/list/by/tea/{teaUUID}/{grade}")
    List<Map<String, Object>> queryClassByTeaUUIDAndGrade(@PathVariable("teaUUID") String teaUUID,@PathVariable("grade") String grade){
        return clazzService.queryClassByTeaUUIDAndGrade(teaUUID, grade);
    }

    @ApiOperation("根据届查询班级")
    @GetMapping("/list/by/{grade}/{currentPage}")
    public PageInfo<Map<String,Object>>queryClassByGrade(@PathVariable("grade") String grade,@PathVariable("currentPage") int currentPage){
        return clazzService.queryClassByGrade(grade, currentPage);
    }
}

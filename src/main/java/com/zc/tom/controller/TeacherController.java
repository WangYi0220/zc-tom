package com.zc.tom.controller;

import com.zc.tom.common.myAnnotation.Root;
import com.zc.tom.common.utils.DownloadFileUtil;
import com.zc.tom.pojo.Result;
import com.zc.tom.pojo.Teacher;
import com.zc.tom.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    private static final String PATH = "/usr/tom/file";
    private static final String FILENAME = "teacher.xlsx";
    private static final String NAME = "辅导员信息模板";

    @ApiOperation(value = "辅导员信息模板下载", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @RequestMapping(value = "/download", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Object downloadModel() {
        ResponseEntity<InputStreamResource> response = null;
        try {
            response = DownloadFileUtil.download(PATH, FILENAME, NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ApiOperation("查看辅导员信息列表")
    public List<Teacher> queryTeacherList(){
        return teacherService.queryTeacherList();
    }

    @RequestMapping(value = "/import",method = RequestMethod.POST)
    @ApiOperation("导入辅导员信息")
    @Root
    public Result importTeacherInfo(MultipartFile multipartFile){
        teacherService.importTeacherInfo(multipartFile);
        return result;
    }

    @RequestMapping(value = "/delete/{teaUUID}",method = RequestMethod.GET)
    @ApiOperation("禁用辅导员")
    @Root
    public Result deleteTeacherStatusByTeaUUID(@PathVariable("teaUUID") String teaUUID){
        teacherService.deleteTeacherStatusByTeaUUID(teaUUID);
        return result;
    }
}

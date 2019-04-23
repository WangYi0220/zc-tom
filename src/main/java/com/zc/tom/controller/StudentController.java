package com.zc.tom.controller;

import com.zc.tom.common.utils.DownloadFileUtil;
import com.zc.tom.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    private static final String PATH = "E:\\";
    private static final String FILENAME ="学生模板.xlsx";
    private static final String NAME="学生信息模板";

    @PostMapping("/import")
    @ApiOperation("学生信息导入")
    public Boolean importStudentInfo(MultipartFile multipartFile,String classUUID){
        studentService.importStudentInfo(multipartFile,classUUID);
        return true;
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "模板下载", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    public Object downloadModel() {
        ResponseEntity<InputStreamResource> response = null;
        try {
            response = DownloadFileUtil.download(PATH, FILENAME, NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}

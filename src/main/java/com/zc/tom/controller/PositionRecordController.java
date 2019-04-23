package com.zc.tom.controller;

import com.zc.tom.pojo.PositionRecord;
import com.zc.tom.pojo.Result;
import com.zc.tom.service.PositionRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:31
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/position/record")
@Api(tags = "学生职位变动记录信息操作接口(lxl)")
public class PositionRecordController {
    @Autowired
    private PositionRecordService positionRecordService;
    @Autowired
    private Result result;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuUUID",value = "学生编号",paramType = "query"),
            @ApiImplicitParam(name = "prName",value = "变动名称",paramType = "query"),
            @ApiImplicitParam(name = "remark",value = "职位名称",paramType = "query"),
    })
    @ApiOperation("添加学生职位变动记录信息")
    public Result addPositionRecord(@ApiIgnore PositionRecord positionRecord){
        positionRecordService.addPositionRecord(positionRecord);
        return result;
    }
}

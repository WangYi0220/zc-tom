package com.zc.tom.controller;

import com.zc.tom.pojo.QueryVo;
import com.zc.tom.pojo.Result;
import com.zc.tom.pojo.StipulationRecord;
import com.zc.tom.service.StipulationRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:39
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/stipulation/record")
@Api(tags = "赏罚记录信息操作接口(lxl)")
public class StipulationRecordController {
    @Autowired
    private StipulationRecordService stipulationRecordService;
    @Autowired
    private Result result;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuUUID",value = "学生编号",paramType = "query"),
            @ApiImplicitParam(name = "sID",value = "赏罚分类编号",paramType = "query"),
            @ApiImplicitParam(name = "srName",value = "赏罚名称",paramType = "query"),
            @ApiImplicitParam(name = "remark",value = "赏罚说明",paramType = "query"),
    })
    @ApiOperation("添加赏罚记录信息")
    public Result addStipulationRecord(@ApiIgnore StipulationRecord stipulationRecord) {
        stipulationRecordService.addStipulationRecord(stipulationRecord);
        return result;
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuUUID",value = "学生编号",paramType = "query"),
            @ApiImplicitParam(name = "flag",value = "赏罚区分，1=赏，0=罚",paramType = "query"),
            @ApiImplicitParam(name = "beginTime",value = "赏罚开始时间",paramType = "query"),
            @ApiImplicitParam(name = "endTime",value = "赏罚结束时间",paramType = "query"),
    })
    @ApiOperation("根据查询条件查询学生赏罚信息列表")
    public List<Map<String, Object>> queryStudentStipulationInfoByConditions(@ApiIgnore QueryVo queryVo) {
        return stipulationRecordService.queryStudentStipulationInfoByConditions(queryVo);
    }
}

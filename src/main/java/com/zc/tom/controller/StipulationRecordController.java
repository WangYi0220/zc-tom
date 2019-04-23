package com.zc.tom.controller;

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
            // stuUUID, sID, srName, remark, createTime
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
}

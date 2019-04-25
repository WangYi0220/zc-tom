package com.zc.tom.controller;

import com.zc.tom.common.myAnnotation.Root;
import com.zc.tom.pojo.Position;
import com.zc.tom.pojo.Result;
import com.zc.tom.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
 * @date ：Created in 2019/4/22 22:27
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/position")
@Api(tags = "职位信息操作接口(lxl)")
public class PositionController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private Result result;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ApiOperation("查看职位信息列表")
    public List<Position> queryPositionList(){
        return positionService.queryPositionList();
    }

    @RequestMapping(value = "/get/{postID}",method = RequestMethod.GET)
    @ApiOperation("根据编号查看职位详细信息")
    public Position queryPositionByPostID(@PathVariable("postID")Integer postID){
        return positionService.queryPositionByPostID(postID);
    }

    @RequestMapping(value = "/getStuPositionInfo/{stuUUID}",method = RequestMethod.GET)
    @ApiOperation("根据编号查看学生的职位信息")
    public List<Map<String,Object>> getStudentPositionInfoByStuUUID(@PathVariable("stuUUID") String stuUUID){
        return positionService.getStudentPositionInfoByStuUUID(stuUUID);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "postName",value = "职位名称",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "postSubsidy",value = "岗位补贴",dataType = "String",paramType = "query")
    })
    @ApiOperation("添加职位信息")
    @Root
    public Result addPosition(@ApiIgnore Position position){
        positionService.addPosition(position);
        return result;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "postName",value = "职位名称",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "postSubsidy",value = "岗位补贴",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "postID",value = "职位编号",dataType = "String",paramType = "query")
    })
    @ApiOperation("修改职位信息")
    @Root
    public Result updatePosition(@ApiIgnore Position position){
        positionService.updatePosition(position);
        return result;
    }
}

package com.zc.tom.controller;

import com.zc.tom.pojo.Stipulation;
import com.zc.tom.service.StipulationService;
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
 * @date ：Created in 2019/4/22 22:33
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/stipulation")
@Api(tags = "赏罚信息操作接口(lxl)")
public class StipulationController {
    @Autowired
    private StipulationService stipulationService;

    @RequestMapping(value = "/list/{scID}",method = RequestMethod.GET)
    @ApiOperation("查看赏罚条例信息列表")
    public List<Map<String,Object>> queryStipulationList(@PathVariable("scID") Integer scID){
        return stipulationService.queryStipulationList(scID);
    }

    @RequestMapping(value = "/get/{sID}",method = RequestMethod.GET)
    @ApiOperation("根据编号查看赏罚条例信息列表")
    public Map<String,Object> queryStipulationBySID(@PathVariable("sID") Integer sID){
        return stipulationService.queryStipulationBySID(sID);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "scID",value = "赏罚分类",paramType = "query"),
            @ApiImplicitParam(name = "sName",value = "规定名称",paramType = "query"),
            @ApiImplicitParam(name = "sMoney",value = "赏罚金额, 奖为整数，罚为负数",paramType = "query"),
            @ApiImplicitParam(name = "sRemark",value = "规定说明",paramType = "query"),
            @ApiImplicitParam(name = "sValue",value = "加减分项，加为整数，减为负数",paramType = "query")
    })
    @ApiOperation("添加赏罚条例")
    public Boolean addStipulation(@ApiIgnore Stipulation stipulation){
        System.out.println("stipulation = " + stipulation);
        stipulationService.addStipulation(stipulation);
        return true;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sMoney",value = "赏罚金额,奖为整数，罚为负数",paramType = "query"),
            @ApiImplicitParam(name = "sRemark",value = "规定说明",paramType = "query"),
            @ApiImplicitParam(name = "sValue",value = "加减分项，加为整数，减为负数",paramType = "query"),
            @ApiImplicitParam(name = "sID",value = "规定编号",paramType = "query")
    })
    @ApiOperation("修改赏罚条例")
    public Boolean updateStipulation(@ApiIgnore Stipulation stipulation){
        System.out.println("stipulation = " + stipulation);
        stipulationService.updateStipulation(stipulation);
        return true;
    }
}

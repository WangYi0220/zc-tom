package com.zc.tom.controller;

import com.zc.tom.pojo.StipulationClassify;
import com.zc.tom.service.StipulationClassifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:36
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/stipulation/classify")
@Api(tags = "赏罚分类信息操作接口(lxl)")
public class StipulationClassifyController {
    @Autowired
    private StipulationClassifyService stipulationClassifyService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ApiOperation("查看赏罚分类信息列表")
    public List<StipulationClassify> queryStipulationClassifyList(){
        return stipulationClassifyService.queryStipulationClassifyList();
    }
}

package com.zc.tom.controller;

import com.zc.tom.common.myAnnotation.Root;
import com.zc.tom.pojo.Level;
import com.zc.tom.pojo.Result;
import com.zc.tom.service.LevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author ：xie yuan yang
 * @date ：Created in 2019/4/22 22:27
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/level")
@Api(tags = {"等级操作（xyy）"})
public class LevelController {
    @Autowired
    private LevelService levelService;

    @Autowired
    private Result result;

    @ApiOperation("等级调整")
    @GetMapping("/update")
    @Root
    public Result updateStudentLevel(){
        levelService.updateStudentLevel();
        return result;
    }


    @ApiOperation("修改等级基本工资")
    @PostMapping("/update/salary")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "levelID",value = "等级编号",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "salary",value = "工资",dataType = "int" ,paramType = "query"),
            @ApiImplicitParam(name = "coefficient",value = "等级系数",dataType = "int" ,paramType = "query")
    })
   public Result updateLevelByLevelID(@ApiIgnore Level level){
        System.out.println(level.toString());
       levelService.updateLevelByLevelID(level);
       return result;
    }

    @ApiOperation("查询等级表")
    @GetMapping("/level/list")
    public List<Level> queryLevel(){
        return levelService.queryLevel();
    }
}

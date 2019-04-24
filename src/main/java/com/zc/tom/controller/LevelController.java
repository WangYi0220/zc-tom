package com.zc.tom.controller;

import com.zc.tom.pojo.Result;
import com.zc.tom.service.LevelService;
import com.zc.tom.service.LevelServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result updateStudentLevel(){
        levelService.updateStudentLevel();
        return result;
    }


    @ApiOperation("修改等级基本工资")
    @GetMapping("update/salary/{levelID}/{salary}")
   public Result updateLevelByLevelID(@PathVariable int levelID,@PathVariable int salary){
       levelService.updateLevelByLevelID(levelID,salary);
       return result;
    }
}

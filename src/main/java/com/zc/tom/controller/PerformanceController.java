package com.zc.tom.controller;

import com.zc.tom.pojo.Performance;
import com.zc.tom.pojo.Result;
import com.zc.tom.service.PerformanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/24 21:59
 * @description：
 * @modified By：
 */
@Api(tags = "绩效评分 By WangYi")
@RestController
@RequestMapping("/performance")
public class PerformanceController {
    @Autowired
    private PerformanceService performanceService;
    @Autowired
    private Result result;

    @ApiOperation("根据学生编号查询指定月份的绩效评分，如2019-04。用时沟通--by WangYi")
    @GetMapping("/get/by/{stuUUID}/{date}")
    public Performance getPerformanceByStuUUIDAndCreateTime(@Param("stuUUID") String stuUUID, @Param("date") String date){
        return performanceService.getPerformanceByStuUUIDAndCreateTime(stuUUID, date);
    }

    @ApiOperation("添加学生绩效评分")
    @PostMapping("/add")
    public Result addPerformance(Performance performance){
        performanceService.addPerformance(performance);
        return result;
    }

    @ApiOperation("调整学生绩效评分")
    @PostMapping("/update/score")
    public Result updateScore(Integer score, String perUUID){
        performanceService.updateScore(score, perUUID);
        return result;
    }
}

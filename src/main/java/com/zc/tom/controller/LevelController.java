package com.zc.tom.controller;

import com.zc.tom.service.LevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api(tags = "{等级操作}")
public class LevelController {
    @Autowired
    private LevelService levelService;




}

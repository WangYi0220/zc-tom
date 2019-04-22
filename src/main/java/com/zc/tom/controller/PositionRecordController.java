package com.zc.tom.controller;

import com.zc.tom.service.PositionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:31
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/position/record")
public class PositionRecordController {
    @Autowired
    private PositionRecordService positionRecordService;
}

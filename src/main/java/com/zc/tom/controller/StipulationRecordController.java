package com.zc.tom.controller;

import com.zc.tom.service.StipulationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:39
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/stipulation/record")
public class StipulationRecordController {
    @Autowired
    private StipulationRecordService stipulationRecordService;
}

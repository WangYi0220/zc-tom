package com.zc.tom.service;

import com.zc.tom.pojo.PositionRecord;
/**
 * @author lxl
 * @Date Created in 2019/4/23 20:23
 * @description 赏罚记录
 * @modified By:
 */
public interface PositionRecordService {
    // 添加学生职位变动记录信息
    void addPositionRecord(PositionRecord positionRecord);
}

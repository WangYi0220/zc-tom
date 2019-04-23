package com.zc.tom.mapper;

import com.zc.tom.pojo.PositionRecord;

/**
 * @author lxl
 * @Date Created in 2019/4/23 20:19
 * @description 赏罚分类
 * @modified By:
 */
public interface PositionRecordMapper {
    // 添加学生职位变动记录信息
    void addPositionRecord(PositionRecord positionRecord);
}

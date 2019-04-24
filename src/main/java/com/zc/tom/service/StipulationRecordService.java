package com.zc.tom.service;

import com.zc.tom.pojo.QueryVo;
import com.zc.tom.pojo.StipulationRecord;

import java.util.List;
import java.util.Map;

/**
 * @author lxl
 * @Date Created in 2019/4/23 19:40
 * @description 赏罚记录
 * @modified By:
 */
public interface StipulationRecordService {
    // 添加学生赏罚记录信息
    void addStipulationRecord(StipulationRecord stipulationRecord);

    // 根据查询条件查询学生赏罚信息列表
    List<Map<String,Object>> queryStudentStipulationInfoByConditions(QueryVo queryVo);
}

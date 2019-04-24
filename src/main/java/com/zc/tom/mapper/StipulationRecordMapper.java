package com.zc.tom.mapper;

import com.zc.tom.pojo.QueryVo;
import com.zc.tom.pojo.StipulationRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lxl
 * @Date Created in 2019/4/23 19:24
 * @description 赏罚记录
 * @modified By:
 */
public interface StipulationRecordMapper {
    // 添加学生赏罚记录信息
    void addStipulationRecord(StipulationRecord stipulationRecord);

    // 根据查询条件查询学生赏罚信息列表
    List<Map<String,Object>> queryStudentStipulationInfoByConditions(@Param("queryVo")QueryVo queryVo);
}

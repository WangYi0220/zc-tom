package com.zc.tom.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StatisticsMapper {
     List<Map<String, Object>> statistics(@Param("classUUID") String classUUID, @Param("beginDate") String beginDate, @Param("endDate") String endDate);
}

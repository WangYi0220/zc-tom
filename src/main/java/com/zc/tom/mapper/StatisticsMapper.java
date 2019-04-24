package com.zc.tom.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StatisticsMapper {
     List<Map<String, Object>> statistics(@Param("classUUID") String classUUID);

     List<Map<String, Object>> checkIn(@Param("classUUID") String classUUID);
}

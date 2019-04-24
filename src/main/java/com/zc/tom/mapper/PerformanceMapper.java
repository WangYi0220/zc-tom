package com.zc.tom.mapper;

import com.zc.tom.pojo.Performance;
import org.apache.ibatis.annotations.Param;

public interface PerformanceMapper {
    Performance getPerformanceByStuUUIDAndCreateTime(@Param("stuUUID") String stuUUID, @Param("date") String date);

    void addPerformance(Performance performance);

    void updateScore(@Param("score") Integer score, @Param("perUUID") String perUUID);
}

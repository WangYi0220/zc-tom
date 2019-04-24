package com.zc.tom.service;

import com.zc.tom.pojo.Performance;

public interface PerformanceService {
    Performance getPerformanceByStuUUIDAndCreateTime(String stuUUID, String date);

    void addPerformance(Performance performance);

    void updateScore(Integer score, String perUUID);
}

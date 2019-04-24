package com.zc.tom.service;

import com.zc.tom.common.utils.UUIDUtils;
import com.zc.tom.mapper.PerformanceMapper;
import com.zc.tom.pojo.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/24 21:56
 * @description：
 * @modified By：
 */
@Service
@Transactional
public class PerformanceServiceImpl implements PerformanceService {
    @Autowired
    private PerformanceMapper performanceMapper;

    /**
     * 根据学生编号查询指定月份的绩效评分，如2019-04
     * @param stuUUID
     * @param date
     * @return
     */
    @Override
    public Performance getPerformanceByStuUUIDAndCreateTime(String stuUUID, String date) {
        return performanceMapper.getPerformanceByStuUUIDAndCreateTime(stuUUID, date);
    }

    /**
     * 添加学生绩效评分
     * @param performance
     */
    @Override
    public void addPerformance(Performance performance) {
        performance.setPerUUID(UUIDUtils.getUUID());
        performanceMapper.addPerformance(performance);
    }

    /**
     * 修改已有分值本月可改
     * @param score
     * @param perUUID
     */
    @Override
    public void updateScore(Integer score, String perUUID) {
        performanceMapper.updateScore(score, perUUID);
    }
}

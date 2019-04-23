package com.zc.tom.service;

import com.zc.tom.mapper.LevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:25
 * @description：
 * @modified By：
 */
@Service
@Transactional
public class LevelServiceImpl implements LevelService {

    @Autowired
    private LevelMapper levelMapper;


    //等级调整
    @Override
    public void updateStudentLevel() {
        levelMapper.updateStudentLevel();
    }

    //调整等级的基本薪资
    @Override
    public void updateLevelByLevelID(int levelID,int salary) {
        levelMapper.updateLevelByLevelID(levelID,salary);
    }
}

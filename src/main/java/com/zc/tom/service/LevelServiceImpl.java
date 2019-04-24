package com.zc.tom.service;

import com.zc.tom.mapper.LevelMapper;
import com.zc.tom.pojo.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void updateLevelByLevelID(Level level) {
        levelMapper.updateLevelByLevelID(level);
    }

    //查询等级表
    @Override
    public List<Level> queryLevel() {
       return levelMapper.queryLevel();
    }
}

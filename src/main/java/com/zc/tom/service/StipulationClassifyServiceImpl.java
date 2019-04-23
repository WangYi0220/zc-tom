package com.zc.tom.service;

import com.zc.tom.mapper.StipulationClassifyMapper;
import com.zc.tom.pojo.StipulationClassify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:35
 * @description：
 * @modified By：
 */
@Service
@Transactional
public class StipulationClassifyServiceImpl implements StipulationClassifyService {
    @Autowired
    private StipulationClassifyMapper stipulationClassifyMapper;

    // 查看赏罚分类信息列表
    @Override
    public List<StipulationClassify> queryStipulationClassifyList() {
        return stipulationClassifyMapper.queryStipulationClassifyList();
    }
}

package com.zc.tom.service;

import com.zc.tom.mapper.StipulationMapper;
import com.zc.tom.pojo.Stipulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:33
 * @description：
 * @modified By：
 */
@Service
@Transactional
public class StipulationServiceImpl implements StipulationService {
    @Autowired
    private StipulationMapper stipulationMapper;

    // 查看赏罚条例信息列表
    @Override
    public List<Map<String,Object>> queryStipulationList() {
        return stipulationMapper.queryStipulationList();
    }

    // 根据编号查看赏罚条例信息
    @Override
    public Map<String,Object> queryStipulationBySID(Integer sID) {
        return stipulationMapper.queryStipulationBySID(sID);
    }

    // 添加赏罚条例
    @Override
    public void addStipulation(Stipulation stipulation) {
        stipulationMapper.addStipulation(stipulation);
    }

    // 修改赏罚条例
    @Override
    public void updateStipulation(Stipulation stipulation) {
        stipulationMapper.updateStipulation(stipulation);
    }
}

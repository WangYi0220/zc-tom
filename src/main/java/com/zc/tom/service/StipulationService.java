package com.zc.tom.service;

import com.zc.tom.pojo.Stipulation;

import java.util.List;
import java.util.Map;

/**
 * @author lxl
 * @Date Created in 2019/4/23 8:56
 * @description 赏罚
 * @modified By:
 */
public interface StipulationService {
    // 查看赏罚条例信息列表
    List<Map<String,Object>> queryStipulationList();

    // 根据编号查看赏罚条例信息
    Map<String,Object> queryStipulationBySID(Integer sID);

    // 添加赏罚条例
    void addStipulation(Stipulation stipulation);

    // 修改赏罚条例
    void updateStipulation(Stipulation stipulation);
}

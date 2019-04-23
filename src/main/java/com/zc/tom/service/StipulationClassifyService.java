package com.zc.tom.service;

import com.zc.tom.pojo.StipulationClassify;

import java.util.List;
/**
 * @author lxl
 * @Date Created in 2019/4/23 8:56
 * @description 赏罚分类
 * @modified By:
 */
public interface StipulationClassifyService {
    // 查看赏罚分类信息列表
    List<StipulationClassify> queryStipulationClassifyList();
}

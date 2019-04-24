package com.zc.tom.service;

import com.github.pagehelper.PageInfo;
import com.zc.tom.pojo.Clazz;

import java.util.List;
import java.util.Map;

public interface ClazzService {

    /**
     * 添加班级
     * @param clazz
     */
    Clazz insertClazz(Clazz clazz);

    /**
     * 修改班级
     * @param clazz
     */
    Clazz updateClazz(Clazz clazz);

    /**
     * 查询全部班级
     * @return
     */
    PageInfo<Map<String,Object>> queryClass(int currentPage);
}

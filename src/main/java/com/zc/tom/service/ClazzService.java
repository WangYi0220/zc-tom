package com.zc.tom.service;

import com.github.pagehelper.PageInfo;
import com.zc.tom.pojo.Clazz;
import com.zc.tom.pojo.Result;

import java.util.List;
import java.util.Map;

public interface ClazzService {

    /**
     * 添加班级
     * @param clazz
     */
    Result insertClazz(Clazz clazz);

    /**
     * 修改班级
     * @param clazz
     */
    Result updateClazz(Clazz clazz);

    /**
     * 查询全部班级
     * @return
     */
    PageInfo<Map<String,Object>> queryClass(int currentPage);

    List<Map<String, Object>> queryClassByTeaUUIDAndGrade(String teaUUID,String grade);
}

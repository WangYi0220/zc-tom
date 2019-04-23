package com.zc.tom.mapper;

import com.zc.tom.pojo.Clazz;

import java.util.List;
import java.util.Map;

/**
 * 班级操作
 */
public interface ClazzMapper {

    //添加班级
    void insertClazz(Clazz clazz);

     //修改班级
    void updateClazz(Clazz clazz);


    //查询全部班级
    List<Map<String,Object>> queryClass();
}

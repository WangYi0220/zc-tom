package com.zc.tom.mapper;

import com.zc.tom.pojo.Level;

import java.util.List;

/**
 * 等级操作
 */
public interface LevelMapper {

   //等级调整
   void updateStudentLevel();

   //调整等级的基本薪资
   void updateLevelByLevelID(Level level);

   //查询等级表
   List<Level> queryLevel();
}

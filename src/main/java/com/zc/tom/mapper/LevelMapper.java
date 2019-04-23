package com.zc.tom.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * 等级操作
 */
public interface LevelMapper {

   //等级调整
   void updateStudentLevel();

   //调整等级的基本薪资
   void updateLevelByLevelID(@Param("levelID") int levelID ,@Param("salary") int salary);
}

package com.zc.tom.mapper;

import com.zc.tom.pojo.PositionRecord;
import org.apache.ibatis.annotations.Param;

/**
 * @author lxl
 * @Date Created in 2019/4/23 20:19
 * @description 赏罚分类
 * @modified By:
 */
public interface PositionRecordMapper {
    // 学生职位添加， 并添加学生职位变动记录信息
    void addPositionRecord(@Param("positionRecord") PositionRecord positionRecord,@Param("postID") Integer postID);

    // 学生职位升降，并添加学生职位变动记录信息
    void updateStudentPosition(@Param("positionRecord") PositionRecord positionRecord,@Param("oldPostID") Integer oldPostID,
                               @Param("newPostID") Integer newPostID);
}

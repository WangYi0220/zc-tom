package com.zc.tom.service;

import com.zc.tom.pojo.Position;

import java.util.List;
import java.util.Map;

/**
 * @author lxl
 * @Date Created in 2019/4/23 8:56
 * @description 职位
 * @modified By:
 */
public interface PositionService {
    //查看职位信息列表
    List<Position> queryPositionList();

    //根据编号查看职位信息
    Position queryPositionByPostID(Integer postID);

    // 根据编号获取学生的职位信息
    List<Map<String,Object>> getStudentPositionInfoByStuUUID(String stuUUID);

    //添加职位信息
    void addPosition(Position position);

    //修改职位信息
    void updatePosition(Position position);
}

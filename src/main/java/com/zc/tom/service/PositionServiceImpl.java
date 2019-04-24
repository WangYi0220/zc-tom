package com.zc.tom.service;

import com.zc.tom.mapper.PositionMapper;
import com.zc.tom.pojo.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:26
 * @description：
 * @modified By：
 */
@Service
@Transactional
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper positionMapper;

    //查看职位信息列表
    @Override
    public List<Position> queryPositionList() {
        return positionMapper.queryPositionList();
    }

    //根据编号查看职位信息
    @Override
    public Position queryPositionByPostID(Integer postID) {
        return positionMapper.queryPositionByPostID(postID);
    }

    @Override
    public List<Map<String,Object>> getStudentPositionInfoByStuUUID(String stuUUID) {
        return positionMapper.getStudentPositionInfoByStuUUID(stuUUID);
    }

    //添加职位信息
    @Override
    public void addPosition(Position position) {
        positionMapper.addPosition(position);
    }

    //修改职位信息
    @Override
    public void updatePosition(Position position) {
        positionMapper.updatePosition(position);
    }
}

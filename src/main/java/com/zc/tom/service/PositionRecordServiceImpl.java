package com.zc.tom.service;

import com.zc.tom.common.utils.UUIDUtils;
import com.zc.tom.mapper.PositionRecordMapper;
import com.zc.tom.pojo.PositionRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:30
 * @description：
 * @modified By：
 */
@Service
@Transactional
public class PositionRecordServiceImpl implements PositionRecordService {
    @Autowired
    private PositionRecordMapper positionRecordMapper;

    // 学生职位添加，并添加学生职位变动记录信息
    @Override
    public void addPositionRecord(PositionRecord positionRecord,Integer postID) {
        String prUUID = UUIDUtils.getUUID();
        positionRecord.setPrUUID(prUUID);
        positionRecordMapper.addPositionRecord(positionRecord,postID);
    }

    // 学生职位升降，并添加学生职位变动记录信息
    @Override
    public void updateStudentPosition(PositionRecord positionRecord, Integer oldPostID,Integer newPostID) {
        String prUUID = UUIDUtils.getUUID();
        positionRecord.setPrUUID(prUUID);
        positionRecordMapper.updateStudentPosition(positionRecord,oldPostID,newPostID);
    }
}

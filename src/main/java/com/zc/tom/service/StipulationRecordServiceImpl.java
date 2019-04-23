package com.zc.tom.service;

import com.zc.tom.common.utils.UUIDUtils;
import com.zc.tom.mapper.StipulationRecordMapper;
import com.zc.tom.pojo.StipulationRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:38
 * @description：
 * @modified By：
 */
@Service
@Transactional
public class StipulationRecordServiceImpl implements StipulationRecordService {
    @Autowired
    private StipulationRecordMapper stipulationRecordMapper;

    // 添加学生赏罚记录信息
    @Override
    public void addStipulationRecord(StipulationRecord stipulationRecord) {
        String srUUID = UUIDUtils.getUUID();
        stipulationRecord.setSrUUID(srUUID);
        stipulationRecordMapper.addStipulationRecord(stipulationRecord);
    }
}

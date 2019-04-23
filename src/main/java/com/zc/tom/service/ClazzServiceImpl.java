package com.zc.tom.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.tom.common.utils.UUIDUtils;
import com.zc.tom.mapper.ClazzMapper;
import com.zc.tom.pojo.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/22 22:22
 * @description：班级操作
 * @modified By：
 */
@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    /**
     * 添加班级
     * @param clazz
     * @return
     */
    @Override
    public Clazz insertClazz(Clazz clazz) {
        clazz.setClassUUID(UUIDUtils.getUUID());
        clazzMapper.insertClazz(clazz);
        return clazz;
    }

    /**
     * 修改班级
     * @param clazz
     * @return
     */
    @Override
    public Clazz updateClazz(Clazz clazz) {
        clazzMapper.updateClazz(clazz);
        return clazz;
    }

    /**
     * 分页查询 全部班级
     * @param currentPage
     * @return
     */
    @Override
    public PageInfo<Map<String, Object>> queryClass(int currentPage) {
        PageHelper.startPage(currentPage,10);//1.设置pageHelper分页所需的参数
        List<Map<String,Object>> map = clazzMapper.queryClass();//获取每页数据
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(map);//获取分页对象
        return pageInfo;
    }
}

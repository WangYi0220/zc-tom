package com.zc.tom.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.tom.common.utils.UUIDUtils;
import com.zc.tom.mapper.ClazzMapper;
import com.zc.tom.pojo.Clazz;
import com.zc.tom.pojo.Result;
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

    @Autowired
    private Result result;

    /**
     * 添加班级
     * @param clazz
     * @return
     */
    @Override
    public Result insertClazz(Clazz clazz) {
        clazz.setClassUUID(UUIDUtils.getUUID());
        clazzMapper.insertClazz(clazz);
        return result;
    }

    /**
     * 修改班级
     * @param clazz
     * @return
     */
    @Override
    public Result updateClazz(Clazz clazz) {
        clazzMapper.updateClazz(clazz);
        return result;
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

    /**
     * 根据辅导员编号和届查询班级
     * @param teaUUID
     * @param grade
     * @return
     */
    @Override
    public List<Map<String, Object>> queryClassByTeaUUIDAndGrade(String teaUUID, String grade) {
        return clazzMapper.queryClassByTeaUUIDAndGrade(teaUUID, grade);
    }
}

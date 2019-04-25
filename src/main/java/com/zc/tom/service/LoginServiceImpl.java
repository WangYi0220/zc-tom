package com.zc.tom.service;

import com.alibaba.fastjson.JSON;
import com.zc.tom.common.utils.JwtUtils;
import com.zc.tom.mapper.LoginMapper;
import com.zc.tom.pojo.Result;
import com.zc.tom.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/25 11:29
 * @description：
 * @modified By：
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private Result result;


    /**
     * 辅导员登陆
     *
     * @param telephone
     * @param password
     * @return
     */
    @Override
    public String login(String telephone, String password) {
        Map<String, Object> result = new HashMap<>();
        Teacher login = loginMapper.login(telephone, password);
        if (login == null) {
            result.put("status", false);
            return JSON.toJSONString(result);
        }
        result = JwtUtils.createJWT(login.getTeaUUID());
        result.put("teacher", login);
        result.put("status", true);
        return JSON.toJSONString(result);
    }

    /**
     * 修改密码
     * @param params
     * @return
     */
    @Override
    public Result updatePassword(Map<String, Object> params) {
        int i = loginMapper.updatePassword(params);
        if (i == 0)return result.setStatus(false);
        return result;
    }

    /**
     * 为认证提供
     * @param teaUUID
     * @return
     */
    @Override
    public Teacher getForAuthentication(String teaUUID) {
        return loginMapper.getForAuthentication(teaUUID);
    }
}

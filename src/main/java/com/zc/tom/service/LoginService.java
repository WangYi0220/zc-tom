package com.zc.tom.service;

import com.zc.tom.pojo.Result;
import com.zc.tom.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface LoginService {
    String login(String telephone, String password);

    Result updatePassword(Map<String, Object> params);

    Teacher getForAuthentication(@Param("teaUUID") String teaUUID);
}

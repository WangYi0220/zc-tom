package com.zc.tom.mapper;

import com.zc.tom.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface LoginMapper {
    Teacher login(@Param("telephone") String telephone, @Param("password") String password);

    int updatePassword(@Param("params") Map<String, Object> params);

    Teacher getForAuthentication(@Param("teaUUID") String teaUUID);
}

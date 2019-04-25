package com.zc.tom.controller;

import com.zc.tom.common.myAnnotation.Pass;
import com.zc.tom.pojo.Result;
import com.zc.tom.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/25 14:33
 * @description：
 * @modified By：
 */
@Api(tags = "登陆、改密")
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ApiOperation("登陆")
    @Pass
    @PostMapping("/login")
    public String login(String telephone, String password){
        return loginService.login(telephone, password);
    }

    @ApiOperation("修改登陆密码，前端验证新旧秘密是否一样。监听status，为false修改密码失败")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "账号（电话）", paramType = "query"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", paramType = "query"),
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", paramType = "query")
    })
    @PostMapping("/update/password")
    public Result updatePassword(@ApiIgnore @RequestParam Map<String, Object> params){
        System.out.println(params);
        return loginService.updatePassword(params);
    }
}

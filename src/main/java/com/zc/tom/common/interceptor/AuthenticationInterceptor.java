package com.zc.tom.common.interceptor;

import com.auth0.jwt.JWT;
import com.zc.tom.common.myAnnotation.Pass;
import com.zc.tom.common.myAnnotation.Root;
import com.zc.tom.common.utils.JwtUtils;
import com.zc.tom.common.utils.SpringUtils;
import com.zc.tom.pojo.Teacher;
import com.zc.tom.service.LoginService;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/25 15:05
 * @description：
 * @modified By：
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    private LoginService loginService= SpringUtils.getBean(LoginService.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!(handler instanceof HandlerMethod)) return true;
        Method method = ((HandlerMethod) handler).getMethod();
        if (method.isAnnotationPresent(Pass.class)) return true;
        String token = request.getHeader("token");
        if (token == null || "".equals(token.trim())) {
            response.setStatus(401);
            return false;
        }
        if (!JwtUtils.isVerify(token)) {
            response.setStatus(403);
            return false;
        }
        String teaUUID = JWT.decode(token).getClaim("teaUUID").asString();
        System.out.println(teaUUID);
        if (teaUUID == null || "".equals(teaUUID.trim())) {
            response.setStatus(401);
            return false;
        }
        Teacher teacher = loginService.getForAuthentication(teaUUID);
        if (teacher == null) {
            response.setStatus(401);
            return false;
        }
        if (method.isAnnotationPresent(Root.class)) {
            if (!teacher.getRoot()) {
                response.setStatus(401);
                return false;
            }
        }
        return true;
    }
}

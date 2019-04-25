package com.zc.tom.common.config;

import com.zc.tom.pojo.Result;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/zc/**").addResourceLocations("file:D:\\zcimg\\");
    }

    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**/*").excludePathPatterns("/**/swagger-resources/**","/**/v2/**");
    }

    @Bean
    public Result result() {
        return new Result();
    }
}

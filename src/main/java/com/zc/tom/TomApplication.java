package com.zc.tom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.zc.tom.mapper")
@EnableSwagger2
@EnableTransactionManagement
@EnableAsync
public class TomApplication {

    public static void main(String[] args) {
        SpringApplication.run(TomApplication.class, args);
    }

}

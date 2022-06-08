package com.hanxiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan({"com.hanxiao.interceptor", "com.hanxiao.mapstruct"})
@MapperScan("com.hanxiao.tk_mybatis")
public class TkMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TkMybatisApplication.class, args);
    }

}

package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//扫描文件夹

@SpringBootApplication
@MapperScan("com.Chlin.blog.mapper")
@ComponentScan("com.Chlin.blog.mapper")
@ComponentScan("com.Chlin.blog.controller")
@ComponentScan("com.Chlin.blog.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

package com.library.LibraryProject;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 文涛
 * */

@SpringBootApplication
@MapperScan("com.library.LibraryProject.dao")
@EnableAutoConfiguration(exclude={DruidDataSourceAutoConfigure.class})
public class LibraryProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryProjectApplication.class, args);
        System.out.println("系统启动成功");
    }

}


package com.natsuki_kining;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @Author : natsuki_kining
 * @Date : 2020/5/23 23:36
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.natsuki_kining.ur.manager"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

package com.natsuki_kining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动类
 *
 * @Author : natsuki_kining
 * @Date : 2020/5/23 23:36
 */
@SpringBootApplication(scanBasePackages = {"com.natsuki_kining", "com.ruoyi"}, exclude = {DataSourceAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

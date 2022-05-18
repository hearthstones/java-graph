package com.summary.mq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MqApplication
 *
 * @author luchao
 * @since 2022/5/13
 */
@SpringBootApplication
@MapperScan("com.summary.mq.mapper")
public class MqApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqApplication.class, args);
    }

}

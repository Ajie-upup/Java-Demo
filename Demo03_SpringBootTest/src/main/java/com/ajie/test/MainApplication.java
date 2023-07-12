package com.ajie.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ajie
 * @date 2023/7/12
 * @description:
 */
@SpringBootApplication
public class MainApplication {

    private static Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        logger.info("测试模块启动成功！");
    }
}

package com.ajie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author ajie
 * @date 2023/7/5
 * @description:
 */
@SpringBootApplication
@MapperScan("com.ajie.mapper")
public class ExcelTestNewApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExcelTestNewApplication.class, args);
    }
}

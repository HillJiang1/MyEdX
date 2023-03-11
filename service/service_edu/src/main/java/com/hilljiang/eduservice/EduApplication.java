package com.hilljiang.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: HillJiang
 * @Date: 2023/3/11
 * @Version 1.0
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.hilljiang")
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}

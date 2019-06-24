package com.pengbo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: main
 * @author: Mr.Liu
 * @version: v1.0
 * @create: 2019-06-24 23:13
 **/
@SpringBootApplication
public class SpringBootJpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("服务启动完成...");
    }
}

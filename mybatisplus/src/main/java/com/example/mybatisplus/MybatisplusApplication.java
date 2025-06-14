package com.example.mybatisplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisplusApplication {

    public static void main(String[] args) {
        System.out.println("MYSQL_PASSWORD: " + System.getenv("MYSQL_PASSWORD"));
        SpringApplication.run(MybatisplusApplication.class, args);
    }

}

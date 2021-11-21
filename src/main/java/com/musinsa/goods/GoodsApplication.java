package com.musinsa.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoodsApplication {

    public static void main(String[] args) {
        System.out.println("start project");
        SpringApplication.run(GoodsApplication.class, args);
    }

}

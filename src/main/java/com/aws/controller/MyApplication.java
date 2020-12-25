package com.aws.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.aws")
public class MyApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(MyApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

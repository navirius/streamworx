package com.assignment.streamworx.api1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Api1Application {

    public static void main(String[] args) {
        SpringApplication.run(Api1Application.class, args);
    }

}

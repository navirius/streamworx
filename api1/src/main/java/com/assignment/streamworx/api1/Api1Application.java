package com.assignment.streamworx.api1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@SpringBootApplication
@EnableScheduling
@EnableEurekaClient
public class Api1Application {

    public static void main(String[] args) {
        SpringApplication.run(Api1Application.class, args);
    }

}

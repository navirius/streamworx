package com.assignment.streamworx.api2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@EntityScan("com.assignment.streamworx.api2.entity")
public class Api2Application {

    public static void main(String[] args) {
        SpringApplication.run(Api2Application.class, args);
    }

}

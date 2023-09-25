package com.assignment.streamworx.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaServer
public class ApigatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApigatewayApplication.class, args);
    }
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("r1", r -> r.host("**.assignment.streamworx.com")
//                        .and()
//                        .path("/apigateway")
//                        .uri("http://assignment.streamworx.com"))
//                .route(r -> r.host("**.assignment.streamworx.com")
//                        .and()
//                        .path("/myOtherRouting")
//                        .filters(f -> f.prefixPath("/myPrefix"))
//                        .uri("http://othersite.com"))
//                        .build();
//    }
}

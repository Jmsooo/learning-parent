package com.jmye.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 */
@SpringBootApplication
public class GatewayApiApplication9002 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApiApplication9002.class, args);
    }

    @Bean
    public RouteLocator someRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("baidu_route",
                        ps -> ps.path("/**").uri("https://www.baidu.com"))
                .build();
    }
}

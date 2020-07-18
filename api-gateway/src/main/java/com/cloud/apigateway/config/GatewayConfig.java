package com.cloud.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("path_route2", r -> r.path("/user/getByUsername")
                    .uri("http://localhost:8201/user/getByUsername"))
                .route("id_route", r -> r.path("/user/getAllUser")
                    .uri("http://localhost:8201/user/getAllUser"))
                .build();
    }
}

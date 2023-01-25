package com.k8smanager.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator gatewayRoues(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/pod/**")
                        .uri("lb://pod-ws")).build();
    }

}

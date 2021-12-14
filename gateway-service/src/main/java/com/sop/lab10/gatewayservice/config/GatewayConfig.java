package com.sop.lab10.gatewayservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("user-service",r->r.path("/users/**")
                        .filters(f->f.filter(filter))
                        .uri("lb://user-service"))
                .route("auth-service",r->r.path("/auth/**")
                        .filters(f->f.filter(filter))
                        .uri("lb://auth-service"))
                .route("movie-service",r->r.path("/movie/**")
                        .filters(f->f.filter(filter))
                        .uri("lb://movie-service"))
                .route("review-service",r->r.path("/review/**")
                        .filters(f->f.filter(filter))
                        .uri("lb://review-service"))
                .build();
    }
}

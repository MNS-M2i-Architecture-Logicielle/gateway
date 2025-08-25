package com.mnb.gateway;

import com.mnb.gateway.security.JwtAuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()

                .route("auth-service", r -> r
                        .path("/api/auth/**")
                        .uri("http://localhost:8081"))

                .route("account-service", r -> r
                        .path("/api/account/**")
                        .filters(f -> f.filter(new JwtAuthenticationFilter()))
                        .uri("http://localhost:8082"))

                .route("client-service", r -> r
                        .path("/api/client/**")
                        .filters(f -> f.filter(new JwtAuthenticationFilter()))
                        .uri("http://localhost:8082"))

                .route("bank-service", r -> r
                        .path("/api/bank/**")
                        .filters(f -> f.filter(new JwtAuthenticationFilter()))
                        .uri("http://localhost:8083"))

                .route("persistence-service", r -> r
                        .path("/api/persistence/**")
                        .filters(f -> f.filter(new JwtAuthenticationFilter()))
                        .uri("http://localhost:8090"))

                .build();
    }
}

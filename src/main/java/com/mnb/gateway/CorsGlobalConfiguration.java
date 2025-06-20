package com.mnb.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;

/**
 * Global CORS configuration for the gateway service.
 * This configuration allows Cross-Origin Resource Sharing (CORS) requests
 * from any origin, with any HTTP method and headers.
 * It applies to all endpoints (/**).
 * Note: This uses reactive CORS support suitable for WebFlux-based applications.
 */
@Configuration
public class CorsGlobalConfiguration {

    /**
     * Defines a CorsWebFilter bean to handle CORS preflight and actual requests.
     * Configures CORS to allow any origin, method, and header.
     *
     * @return a CorsWebFilter configured with permissive CORS settings
     */
    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}

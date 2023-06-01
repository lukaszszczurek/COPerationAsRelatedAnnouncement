package com.example.coparasystem.security;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import java.util.List;

@Configuration // Ustawienie konfiguracji CORS

public class CorsConfig  {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings( CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")
                        .allowedHeaders("*")
                        .allowedOrigins("http://localhost:4200");
            }
        };
    }

//    @Value("#{'${cors.allowed-origins}'.split(',')}")
//    private List<String> allowedOrigins;
//    @Value("#{'${cors.allowed-methods}'.split(',')}")
//    private List<String> allowedMethods;
//
//    @Value("#{'${cors.allowed-headers}'.split(',')}")
//    private List<String> allowedHeaders;
//
//    @Value("#{'${cors.exposed-headers}'.split(',')}")
//    private List<String> expectedHeaders;
//
//
//
//
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(allowedOrigins);
//        configuration.setAllowedMethods(allowedMethods);
//        configuration.setAllowedHeaders(allowedHeaders);
//        configuration.setExposedHeaders(expectedHeaders);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/api/**", configuration);
//        return source;
//    }


}


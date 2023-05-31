package com.example.coparasystem.auth;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Ustawienie konfiguracji CORS
public class CorsConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Ustaw domenę lub użyj "*" dla dowolnej domeny
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Ustaw dozwolone metody HTTP
                .allowedHeaders("*") // Ustaw dozwolone nagłówki
                .maxAge(3600); // Ustaw maksymalny czas buforowania żądań CORS w sekundach
    }
}


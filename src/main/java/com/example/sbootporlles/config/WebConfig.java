package com.example.sbootporlles.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        
        WebMvcConfigurer.super.addCorsMappings(registry);

        // CORS para desarrollo
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
        
        // CORS para producción - mismo dominio (IIS proxy reverso)
        // Si accedes desde http://tudominio.com/api, IIS hace proxy a localhost:8080
        // Por eso permites localhost
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080", "http://localhost", "http://127.0.0.1")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
    
}

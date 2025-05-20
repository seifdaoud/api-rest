package com.github.seif.apirest.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info()
                .title("API RESTful Best Practices")
                .version("v1.0.0")
                .description("Exemple d'API propre avec Spring Boot 3"));
    }
}

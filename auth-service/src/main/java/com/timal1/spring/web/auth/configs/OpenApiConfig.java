package com.timal1.spring.web.auth.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(
                        new Info()
                        .title("Timal1 - Spring-Web - Сервис Авторизации")
                        .version("1")
                );
    }
}

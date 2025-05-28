package com.zia.smartmail.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "SmartMail Assist API",
                version = "1.0",
                description = "AI-powered email reply generator built with Spring Boot"
        )
)
public class OpenApiConfig {
}

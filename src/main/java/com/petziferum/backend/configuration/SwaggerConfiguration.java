package com.petziferum.backend.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI(@Value("${spring.application.name}") String appName){
     return new OpenAPI()
             .openapi("3.0.1")
             .info(new Info()
                     .version("1.0.0")
                     .title(appName)
                     .description("Ein Backend Service für das Straßen Verwaltungs-Tool")
                     .contact(new Contact()
                             .name("Max Mustermann")
                             .url("http://www.example.de")
                             .email("max.mustermann@muenchen.de")
                     )

             );
    }
}

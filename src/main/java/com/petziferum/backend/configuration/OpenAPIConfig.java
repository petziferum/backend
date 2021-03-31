package com.petziferum.backend.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {


    public OpenAPI customOpenAPI(){
     return new OpenAPI()
             .info(new Info()
             .title("Petzis OpenAPI 3.0 Backend")
             .version("0.1.0")
                     .description("Eine Spielwiese")
                     .termsOfService(null)
                     .contact(new Contact()
                     .email("daboarderpjb@gmail.com")
                     .name("Patrick Bussler"))
                     .license(null)
             );
    }
}

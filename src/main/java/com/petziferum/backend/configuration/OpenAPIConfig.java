package com.petziferum.backend.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI(){
     return new OpenAPI()
             .components(new Components())
             .info(new Info()
                     .version("1.0.0")
                     .title("Petzis OpenAPI 3.0 Backend LOLOLOLOLLLOOOOOLL")
                     .description("Eine Spielwiese. Mehr Infos unter https://swagger.io/specification/#info-version")
                     .termsOfService(null)
                     .contact(new Contact().name("Patrick Bussler").url("http://www.patrickbussler.de").email("daboarderpjb@gmail.com")
                     )
                     .license(null)

             );
    }
}

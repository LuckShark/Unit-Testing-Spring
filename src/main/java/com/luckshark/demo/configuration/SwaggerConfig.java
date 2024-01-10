package com.luckshark.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
    public OpenAPI apiDocConfig() {
           return new OpenAPI()
                .info(new Info()
                        .title("Sales Shark API")
                        .description("example API for routing ")
                        .version("0.0.1")
                        .contact(new Contact()
                                .name("example")
                                .email("exaample@z.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentation")
                        .url("https:/wiki...."));
    }
}

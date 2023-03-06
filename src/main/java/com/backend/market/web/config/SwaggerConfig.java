package com.backend.market.web.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI springShopOpenAPI() {
    return new OpenAPI()
        .info(new Info().title("Mantequilla - Market API")
            .description("Marketplace application")
            .version("v1.0")
            .license(new License().name("Apache 2.0").url("https://springdoc.org/v2/")))
        .externalDocs(new ExternalDocumentation()
            .description("More projects on my GitHub")
            .url("https://github.com/Viclo"));
  }
}

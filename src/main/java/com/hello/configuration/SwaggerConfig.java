package com.hello.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

  @Value("${application.name}")
  private String title;

  @Value("${application.description}")
  private String description;

  @Value("${application.version}")
  private String version;

  @Value("${server.servlet.context-path}")
  private String contextPath;

  @Bean
  public OpenAPI openApiBean() throws IOException {
    return new OpenAPI()
        .info(new Info().title(title)
            .description(description)
            .version(version))
        .addServersItem(new Server().url("http://localhost:8080" + contextPath).description("ENV"));
  }
}

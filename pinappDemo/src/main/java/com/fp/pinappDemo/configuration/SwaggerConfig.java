package com.fp.pinappDemo.configuration;

import io.swagger.v3.oas.models.media.DateSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Client API")
                        .version("1.0")
                        .description("Client API Documentation"))
                .servers(List.of(
                        new Server().url("https://pinappdemo.foxtrotpotato.com")
                ))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSchemas("Date", new DateSchema().format("yyyy-MM-dd")));

    }

}

package com.mjudb.officeservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

@Configuration
public class SwaggerConfig {
    private static final String REFERENCE = "Bearer ";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(SwaggerInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.mjudb.officeservice.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo SwaggerInfo() {
        return new ApiInfoBuilder()
                .title("mju-db Swagger")
                .description("메인 API Swagger 문서")
                .version("1.0")
                .build();
    }

}
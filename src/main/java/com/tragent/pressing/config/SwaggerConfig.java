package com.tragent.pressing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@PropertySource("classpath:swagger.properties")
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket userApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.tragent.pressing.controller"))
                .paths(regex("/api/v1/users.*"))
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Pressing REST API",
                "REST API for Pressing Management System",
                "1.0",
                "Terms of service",
                new Contact("Awasum Yannick", "http://skylabase.com/", "awasum.yannick@skylabase.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }



}

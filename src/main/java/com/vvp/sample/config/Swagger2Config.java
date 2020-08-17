package com.vvp.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {
    /**
     * Get swagger docket resource.
     * @return swagger docket resource
     */
    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.vvp"))
                .paths(PathSelectors.ant("/v1/**"))
                .build()
                .pathMapping("/")
                .apiInfo(metadata());
    }

    /**
     * Get api metadata.
     * @return api metadata
     */
    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Account API")
                .description("Details regarding available endpoints")
                .version("1.0")
                .build();
    }
}

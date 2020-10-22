package com.example.demo2.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

@Configuration
@EnableSwagger2
public class Swagger2Config implements WebMvcConfigurer {
    @Bean
    public Docket demo2() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(apis()).paths(paths()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Demo APIs")
                .description("Backend APIs for Demo")
                .license("MIT License").licenseUrl("#")
                .version("0.0.1").build();
    }

    private Predicate<RequestHandler> apis() {
        return RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class);
    }

    private Predicate<String> paths() {
        return PathSelectors.any();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger2/**").addResourceLocations("classpath:/META-INF/resources/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/swagger2/api-docs", "/api-docs");
        registry.addRedirectViewController("/swagger2/swagger-resources/configuration/ui",
                "/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/swagger2/swagger-resources/configuration/security",
                "/swagger-resources/configuration/security");
        registry.addRedirectViewController("/swagger2/swagger-resources", "/swagger-resources");
    }
}

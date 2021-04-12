package com.example.restfulwebservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private  static final Contact DEFAULT_CONTACT = new Contact("Kennth lee", "http://www.chosun.com", "skdf@josin.com");
    private  static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome API Title", "My user management REST API service", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://apache.org/license/LICENCE-2.0", new ArrayList<>());
    private  static  final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("application/json", "application/xml")); //asList 배열 -> 리스트로 변경

    @Bean
    public Docket api(){
        //http://localhost:8088/v2/api-docs
        //http://localhost:8088/swagger-ui.html
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}

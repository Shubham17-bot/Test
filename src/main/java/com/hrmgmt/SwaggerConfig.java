package com.hrmgmt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis((Predicate<RequestHandler>) RequestHandlerSelectors.basePackage("com.hrmgmt"))
				
				.build().apiInfo(apiInfo())
				.securitySchemes(
						new ArrayList<>(Arrays.asList(new ApiKey("Bearer %token", "Authorization", "Header"),new ApiKey("id", "id", "Header"))))
				;
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Api", "", "API 1.0", "Terms of service",
				new Contact("", "", ""), "License of API", "API license URL",
				Collections.emptyList());
	}

}


package com.eprakash.learn.microservices.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	  public static final Contact DEFAULT_CONTACT = new Contact("Jaya Prakash", "www.j.com", "kuna.jprakash@gmail.com");
	  
	  public static final ApiInfo DEFAUT_API_INFO = new 
			  ApiInfo("Microservices Learning ApI's", 
					  "Microservices Learning ApI's Documentation", 
					  "1.0",
					  "urn:tos",
	          DEFAULT_CONTACT, 
	          "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMERS = new HashSet<>(Arrays.asList("application/json","application/xml"));

	// define bean

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAUT_API_INFO)
				.produces(DEFAULT_PRODUCES_AND_CONSUMERS)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMERS);
	}

	
	
}

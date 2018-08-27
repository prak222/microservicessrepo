package com.eprakash.learn.microservices;


import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class MicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}
	
	
/*	@Bean
	public LocaleResolver localResolver()
	{
		SessionLocaleResolver localeResolver= new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}*/
	
	//we are using sessionLocale instead use AcceptHeaderLocale
	
	@Bean
	public LocaleResolver localResolver()
	{
		AcceptHeaderLocaleResolver localeResolver= new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
/*	@Bean
	public ResourceBundleMessageSource messageSource()
	{
		ResourceBundleMessageSource bundleMessageSource =new ResourceBundleMessageSource();
		bundleMessageSource.setBasename("messages");
		return bundleMessageSource;
	}*/
	
	//this messageSource() can be set in application.properties
	
}

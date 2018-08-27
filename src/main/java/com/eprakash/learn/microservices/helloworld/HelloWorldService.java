package com.eprakash.learn.microservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldService {
	
	
	@Autowired
	private MessageSource  messageSource;
	
	@RequestMapping(method=RequestMethod.GET , path="/helloworld")
	public  String getHelloWorld()
	{
		return "HelloWorld";
	}   
		
	
	@GetMapping(path="/helloworldgm")
	public  String getGetMappingHelloWorld()
	{
		return "HelloWorldGetMapping";
	}
	
	
	@GetMapping(path="/helloworld_bean")
	public  HelloWorldBean getHelloWorldBean()
	{
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path="/helloworld/pathvariable/{name}")
	public  String helloWorldPathVariable(@PathVariable String name)
	{
		return  String.format("Hello World %s",name);
	}
	
	@GetMapping(path="/helloworld-I18N")
	public String helloWorldI18N() {
		
	return messageSource.getMessage("good.morning.message", null,LocaleContextHolder.getLocale());
		
	}
	
}

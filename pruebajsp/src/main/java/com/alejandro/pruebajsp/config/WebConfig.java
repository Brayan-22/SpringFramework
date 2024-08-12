package com.alejandro.pruebajsp.config;

import java.time.Duration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig{// implements WebMvcConfigurer{
	
	@Bean
	MessageSource messageSource() {
		ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
		rbms.addBasenames("messages");
		return rbms;
	}
	/*
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/WEB-INF/resources/**")
		.addResourceLocations("/WEB-INF/resources/")
		.setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));	
	}*/
}

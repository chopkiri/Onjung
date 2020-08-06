package com.onshuu.www.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.onshuu.www.interceptor.LoggerInterceptor;


@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(new LoggerInterceptor());
	}
	
}
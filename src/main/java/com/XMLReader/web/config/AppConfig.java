package com.XMLReader.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import com.XMLReader.web.controller.NotifyAspect;

@Configuration
@ComponentScan (basePackages = {"com.XMLReader.web"}, excludeFilters = { @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION)})
@EnableAspectJAutoProxy
public class AppConfig {
	
	//T-TODO [thuynh40 Nov 29, 2017] Config
	
	@Bean
	public NotifyAspect notifyAspect() {
	    return new NotifyAspect();
	}

}

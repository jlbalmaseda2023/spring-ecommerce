package com.curso.ecommerce;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration()
public class ResourcesWebConfiguration implements WebMvcConfigurer {

	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		//registry.addResourceHandler("/images/**").addResourceLocations("//images/");
		registry.addResourceHandler("/images/**").addResourceLocations("file:///C:/WS/spring-ecommerce/images/");
	}

}

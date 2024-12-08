package com.springmvc.lc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class<?> configClass[] = {DispatcherConfig.class}; 
		return configClass;
	}

	@Override
	protected String[] getServletMappings() {
		String mapping[] = {"/"};
		return mapping;
	}

}

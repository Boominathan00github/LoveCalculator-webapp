package com.springmvc.lc.config;

import java.util.Properties;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.springmvc.lc.controller", "com.springmvc.lc.service" })
@PropertySource(value = "classpath:email.properties")
public class DispatcherConfig implements WebMvcConfigurer {

	//setup Email Properties with help of Environment object
	@Autowired
	private Environment environment;

	Logger logger = Logger.getLogger(DispatcherConfig.class.getName());

	//setting View Page in Prefix & Suffix 
	@Bean
	InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;

	}

	//setup Email properties in JavaMailSender object
	@Bean
	public JavaMailSender getJavaMailSender() {

		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

		javaMailSender.setHost(environment.getProperty("mail.host"));
		javaMailSender.setUsername(environment.getProperty("mail.username"));
		javaMailSender.setPassword(environment.getProperty("mail.password"));
		javaMailSender.setPort(getIntProperty("mail.port"));

		javaMailSender.setJavaMailProperties(getMailProperties());

		return javaMailSender;
	}

	//setup JavaMailProperties
	private Properties getMailProperties() {

		Properties properties = new Properties();

		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

		return properties;
	}

	//setup the JavaMailSender property Port to help  -> getMailProperties()
	private int getIntProperty(String key) {

		String property = environment.getProperty(key);

		return Integer.parseInt(property);
	}

}
package com.luxoft.springioc.example39;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:jdbc.properties")
@Lazy
public class AppConfig {

	@Value("${jdbc.url}")
	private String url;


	@Autowired
	private Environment env;

	public Environment getEnv() {
		return env;
	}

	public String getUrl() {
		return url;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		AppConfig config = ctx.getBean(AppConfig.class);

		System.out.println(config.getEnv().getProperty("jdbc.url"));
		System.out.println(config.getEnv().getProperty("jdbc.username"));
		System.out.println(config.getEnv().getProperty("jdbc.password"));

		System.out.println(config.getUrl());

		ctx.close();
	}

}

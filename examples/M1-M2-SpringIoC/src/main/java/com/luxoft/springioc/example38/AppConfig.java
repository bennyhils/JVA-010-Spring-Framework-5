package com.luxoft.springioc.example38;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:example38/application-context.xml")
public class AppConfig {
	
	@Value("${jdbc.url}")
    private String url;

	@Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;
    
    public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

    public static void main(String[] args) {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	AppConfig config = ctx.getBean(AppConfig.class);
    	
    	System.out.println(config.getUrl());
    	System.out.println(config.getUsername());
    	System.out.println(config.getPassword());
    	
    	ctx.close();
    }

}

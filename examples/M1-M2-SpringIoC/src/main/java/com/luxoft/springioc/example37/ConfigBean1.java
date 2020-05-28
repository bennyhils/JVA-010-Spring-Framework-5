package com.luxoft.springioc.example37;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean1 {
	
   @Bean
   public Bean1 bean1() {
      return new Bean1(); 
   }
}
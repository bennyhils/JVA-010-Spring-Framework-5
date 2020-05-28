package com.luxoft.springioc.example37;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ConfigBean1.class)
public class ConfigBean2 {
   @Bean
   public Bean2 bean2() {
      return new Bean2(); 
   }
}

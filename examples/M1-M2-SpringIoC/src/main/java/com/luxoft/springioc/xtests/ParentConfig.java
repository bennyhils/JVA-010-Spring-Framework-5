package com.luxoft.springioc.xtests;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParentConfig
{
	@Bean(name = "Test")
	public A a()
	{
		return new A();
	}
}

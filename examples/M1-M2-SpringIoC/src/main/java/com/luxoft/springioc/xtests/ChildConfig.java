package com.luxoft.springioc.xtests;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ParentConfig.class)
public class ChildConfig
{

    @Bean(name = "Test")
    public B b()
    {
        return new B();
    }

    @Bean(initMethod = "init")
    public Lifecycle lifecycle()
    {
        return new Lifecycle("cArg");
    }
}

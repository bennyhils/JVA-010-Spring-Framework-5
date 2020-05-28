package com.luxoft.springioc.example29;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CommandManager implements ApplicationContextAware, InitializingBean
{
    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        applicationContext.publishEvent(new CustomEvent("test"));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.applicationContext = applicationContext;
    }

}

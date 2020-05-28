package com.luxoft.springioc.xtests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class XTestLauncher
{

    public static void main(String[] args)
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ChildConfig.class);

        System.out.println(ctx.getBean("Test"));
    }
}

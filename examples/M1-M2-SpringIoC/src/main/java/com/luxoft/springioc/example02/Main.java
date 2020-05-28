package com.luxoft.springioc.example02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{

    public static void main(String args[])
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        new String[]{"example02/services.xml", "example02/daos.xml"});

        Service service = context.getBean(ServiceBean.class);

        service.printNames();
    }

}

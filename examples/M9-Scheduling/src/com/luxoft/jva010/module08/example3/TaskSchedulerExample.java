package com.luxoft.jva010.module08.example3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaskSchedulerExample {

    public void printMessages()
    {
        System.out.println("Message " + System.currentTimeMillis());
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("example3/application-context.xml");

        Thread.sleep(1_000_000);

        ((ClassPathXmlApplicationContext) context).close();

    }
}

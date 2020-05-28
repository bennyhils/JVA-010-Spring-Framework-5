package com.luxoft.jva010.module08.example6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {

    public void doIt() {

        System.out.println(Thread.currentThread() + " --> I've called with Quartz :)");
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("example6/application-context.xml");

        Thread.sleep(1_000_000);

        ((ClassPathXmlApplicationContext) context).close();

    }

}

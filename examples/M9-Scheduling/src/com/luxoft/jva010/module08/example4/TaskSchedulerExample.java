package com.luxoft.jva010.module08.example4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskSchedulerExample {

    @Scheduled(fixedDelay = 3000)
    public void printMessages()
    {
        System.out.println("fixedDelay: Message " + System.currentTimeMillis());
    }

    @Scheduled(cron = "*/2 * * * * *")
    public void printMessagesByCron()
    {
        System.out.println("cron: Message " + System.currentTimeMillis());
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("example4/application-context.xml");

        Thread.sleep(1_000_000);

        ((ClassPathXmlApplicationContext) context).close();

    }
}

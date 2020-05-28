package com.luxoft.jva010.module08.example5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import java.util.concurrent.*;

@Service
public class AsyncScheduler {

    @Async
    public void printMessage()
    {
        try {
            Thread.currentThread().sleep(5_000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread() + " :: Hi!!!");
    }

    @Async
    public void sayHello(String name)
    {
        try {
            Thread.currentThread().sleep(5_000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread() + " :: Hello " + name + "!");
    }

    @Async(value = "asyncExecutor")
    public Future<String> returnMessage()
    {
        System.out.println(Thread.currentThread() + " --> Trying to get async result...");

        return new AsyncResult<>(Thread.currentThread() + " :: Async Hi!!!");
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("example5/application-context.xml");

        AsyncScheduler scheduler = context.getBean(AsyncScheduler.class);

        scheduler.printMessage();

        scheduler.sayHello("Oleg");

        System.out.println(scheduler.returnMessage().get());

        Thread.sleep(10_000);

        ((ClassPathXmlApplicationContext) context).close();

    }
}

package com.luxoft.jva010.module08.example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;

public class TaskExecutorExample {

    private TaskExecutor taskExecutor;

    public TaskExecutorExample(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void printMessages() {

        for (int i = 0; i < 25; i++)
        {
            int counter = i;
            taskExecutor.execute(() -> System.out.println(Thread.currentThread().getName() +  " Message: " + counter));
        }
    }

    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("example1/application-context.xml");

        ((TaskExecutorExample) context.getBean("taskExecutorExample")).printMessages();

        ((ClassPathXmlApplicationContext)context).close();
    }

}

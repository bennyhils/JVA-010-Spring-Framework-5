package com.luxoft.jva010.module08.example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

public class CronScheduler {

	private TaskScheduler taskScheduler;

	public CronScheduler(TaskScheduler taskScheduler) {
		this.taskScheduler = taskScheduler;
	}

	public void printMessages()
	{
		for(int i = 0; i < 2; i++)
		{
			int counter = i;
			taskScheduler.schedule(
				() -> System.out.println("Message" + counter),
				new CronTrigger("*/2 * * * * *")
//				new CronTrigger("* 15 9-17 * * MON-FRI")
			);
		}
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("example2/application-context.xml");

		((CronScheduler)context.getBean("cronScheduler")).printMessages();

		Thread.currentThread().sleep(1_000_000);
		((ClassPathXmlApplicationContext)context).close();
	}

}
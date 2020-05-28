package com.luxoft.jva010.module08.example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.TaskScheduler;

public class FixRateScheduler {
	
	private TaskScheduler taskScheduler;

	public FixRateScheduler(TaskScheduler taskScheduler) {
		this.taskScheduler = taskScheduler;
	}

	public void printMessages()
	{
		for(int i = 0; i < 2; i++)
		{
			int counter = i;
			taskScheduler.scheduleAtFixedRate(() -> System.out.println("Message" + counter), 2000);
		}
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("example2/application-context.xml");

		((FixRateScheduler)context.getBean("fixedRateScheduler")).printMessages();

		Thread.sleep(1_000_000);

		((ClassPathXmlApplicationContext)context).close();
	}

}
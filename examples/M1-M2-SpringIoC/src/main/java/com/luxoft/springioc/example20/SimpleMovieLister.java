package com.luxoft.springioc.example20;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleMovieLister {

	private MovieFinder movieFinder;

	public MovieFinder getMovieFinder() {
		return movieFinder;
	}

	@Autowired
	public void setMovieFinder(MovieFinder movieFinder)
	{
		this.movieFinder = movieFinder;
	}

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext(
				"example20/application-context.xml");

		SimpleMovieLister simpleMovieLister =
				(SimpleMovieLister) context.getBean("simpleMovieLister");
		System.out.println(simpleMovieLister.getMovieFinder());

		context.close();

	}

}

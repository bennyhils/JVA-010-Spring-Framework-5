package com.luxoft.springioc.example21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleMovieLister {

//	@Autowired
	private MovieFinder movieFinder;

//	public SimpleMovieLister() {}

	@Autowired
	public SimpleMovieLister(@Qualifier("movieFinder1") MovieFinder movieFinder)
	{
		this.movieFinder = movieFinder;
	}

	public MovieFinder getMovieFinder() {
		return movieFinder;
	}

//	@Autowired
//	@Qualifier("movieFinder23")
//	public void setMovieFinder(FileMovieFinder movieFinder) {
//		System.out.println("-->");
//		this.movieFinder = movieFinder;
//	}

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"example21/application-context.xml");

		SimpleMovieLister simpleMovieLister = (SimpleMovieLister) context.getBean("simpleMovieLister");
		System.out.println(simpleMovieLister.getMovieFinder().getName());

		context.close();

	}

}

package com.luxoft.springioc.example22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleMovieLister {

	private MovieFinder movieFinder;

	public MovieFinder getMovieFinder() {
		return movieFinder;
	}

	@Autowired
	@Qualifier("movieFinder2")
	public void setMovieFinder(MovieFinder movieFinder) {
		this.movieFinder = movieFinder;
	}

	@Autowired
	@Qualifier("movieFinder1")
	public void prepare(MovieFinder movieFinder) {
		System.out.println("Movie finder name: " + movieFinder.getName());
	}

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"example22/application-context.xml");
		
		SimpleMovieLister simpleMovieLister = (SimpleMovieLister) context.getBean("simpleMovieLister");
		System.out.println(simpleMovieLister.getMovieFinder().getName());

		context.close();

	}

}

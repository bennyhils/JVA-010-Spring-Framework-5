package com.luxoft.springioc.movies;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Look https://martinfowler.com/articles/injection.html for details.
 */
public class Launcher
{
    public static void main1(String[] args)
    {
        MovieFinder finder = new FileMovieFinder();

        MovieLister lister = new MovieLister();

        lister.setFinder(finder);

        List<Movie> filtered = lister.moviesDirectedBy("Spielberg");

        print(filtered);
    }

    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "movies/application-context.xml");

        MovieLister lister = (MovieLister) context.getBean("movieLister");
        List<Movie> filtered = lister.moviesDirectedBy("Spielberg");

        print(filtered);
    }

    public static void print(List<?> data)
    {
        System.out.println(data);
    }
}

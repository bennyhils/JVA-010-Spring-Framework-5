package com.luxoft.springioc.movies;

import java.util.ArrayList;
import java.util.List;

/**
 * Dependency Inversion Principal look https://en.wikipedia.org/wiki/SOLID
 */
public class MovieLister
{
    private MovieFinder finder;

    public List<Movie> moviesDirectedBy(String director)
    {
        List<Movie> result = new ArrayList<>();

        for (Movie movie : finder.findAll())
        {
            if (movie.getDirector().equals(director))
            {
                result.add(movie);
            }
        }
        return result;
    }

    public void setFinder(MovieFinder finder)
    {
        this.finder = finder;
    }
}

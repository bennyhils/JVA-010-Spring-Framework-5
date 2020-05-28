package com.luxoft.springioc.movies.direct;

import com.luxoft.springioc.movies.FileMovieFinder;
import com.luxoft.springioc.movies.Movie;

import java.util.ArrayList;
import java.util.List;

public class DirectMovieLister
{
    private FileMovieFinder finder;

    public DirectMovieLister()
    {
        finder = new FileMovieFinder();
    }

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
}

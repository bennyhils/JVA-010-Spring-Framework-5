package com.luxoft.springioc.movies;

import java.util.ArrayList;
import java.util.List;

public class FileMovieFinder implements MovieFinder
{
    private String fileName;

    public List<Movie> findAll()
    {
        return new ArrayList<>();
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
}

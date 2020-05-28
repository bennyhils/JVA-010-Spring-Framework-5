package com.luxoft.jva010.mvc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class InMemoryNamesService implements NamesService
{
    private Set<String> names;

    public InMemoryNamesService()
    {
        names = new HashSet<>();
    }

    @Override
    public List<String> getAll()
    {
        return new ArrayList<>(names);
    }

    @Override
    public Boolean contains(String name)
    {
        return names.contains(name);
    }

    @Override
    public void add(String name)
    {
        names.add(name);
    }
}

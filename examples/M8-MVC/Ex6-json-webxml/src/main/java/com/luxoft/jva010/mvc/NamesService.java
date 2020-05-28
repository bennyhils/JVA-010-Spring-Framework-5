package com.luxoft.jva010.mvc;

import java.util.List;

public interface NamesService
{
    List<String> getAll();

    Boolean contains(String name);

    void add(String name);
}

package com.luxoft.jva010.orm.dao;

import java.util.List;

public interface Dao<T>
{

    void save(T entity);

    List<T> getAll();

    T getByTitle(String title);

}
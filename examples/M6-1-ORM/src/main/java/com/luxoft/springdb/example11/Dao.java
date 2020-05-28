package com.luxoft.springdb.example11;

import java.util.List;

public interface Dao<T>
{
    void insert(final T entity);

    void delete(final T entity);

    void update(int id, String property);

    T findByProperty(String propertyValue);

    List<T> getAll();
}

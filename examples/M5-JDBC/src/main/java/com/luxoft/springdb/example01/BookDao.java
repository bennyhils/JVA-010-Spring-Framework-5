package com.luxoft.springdb.example01;

public interface BookDao
{
    public void printAll();

    public void insert(Book book);

    public void update(int id, String title);

    public void delete(Book book);

    public Book getById(int id);
}

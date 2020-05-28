package com.luxoft.springdb;

import java.util.List;

public interface BookDao
{
    List<Book> getAll();

    void insert(Book book);

    void update(int id, String title);

    void delete(Book book);

    Book findByTitle(String bookTitle);
}

package com.luxoft.jva010.orm.dao.jpa;

import java.util.List;

import com.luxoft.jva010.orm.model.Book;

public interface BookDao
{

    void save(Book book);

    List<Book> getAll();

    Book getBookByTitle(String title);

}
package com.luxoft.springdb.example01;

import java.util.List;

/**
 * Created by oyushche on 11/20/17.
 */
public class BookServiceImpl
{
    private BookDao bookDao;

    public List<Book> getAllBooks() {
        return null;
    }

    public Book getBookById(int id)
    {
        // can be some logic here ...
        return bookDao.getById(id);
    }

    public Book addBook(Book book)
    {
        bookDao.insert(book);

        return book;
    }

    public void setBookDao(BookDao bookDao)
    {
        this.bookDao = bookDao;
    }
}

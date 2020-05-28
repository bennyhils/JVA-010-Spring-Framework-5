package com.luxoft.springdb.example09;

import java.util.List;
import com.luxoft.springdb.Book;
import com.luxoft.springdb.BookDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao
{
    private SessionFactory sessionFactory;

    private Session session;

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
        session = this.sessionFactory.openSession();
    }

    public void insert(Book book)
    {
        Transaction tx = session.beginTransaction();

        session.save(book);

        tx.commit();
    }

    public Book findByTitle(String bookTitle)
    {
        return (Book) session
                .createQuery("from Book where title=?0")
                .setParameter(0, bookTitle)
                .uniqueResult();
    }

    public List<Book> getAll()
    {
        return (List<Book>) session
                .createQuery("from Book")
                .list();
    }

    public void update(int id, String title)
    {
        Transaction tx = session.beginTransaction();

        Book book = session.get(Book.class, id);
        book.setTitle(title);
        session.update(book);

        tx.commit();
    }

    public void delete(Book book)
    {
        Transaction tx = session.beginTransaction();

        session.delete(book);

        tx.commit();
    }


}

package com.luxoft.springdb.example10;

import com.luxoft.springdb.Book;
import com.luxoft.springdb.BookDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class BookDaoImpl extends HibernateDaoSupport implements BookDao
{
    @Transactional
    public void insert(Book book)
    {
        getHibernateTemplate().save(book);
    }

    public Book findByTitle(String bookTitle)
    {
        return (Book) getHibernateTemplate()
                .findByCriteria(DetachedCriteria.forClass(Book.class)
                        .add(Restrictions.ilike("title", bookTitle)))
                .get(0);
    }

    public List<Book> getAll()
    {
        return getHibernateTemplate().loadAll(Book.class);
    }

    @Transactional
    public void update(int id, String title)
    {
        Book book = getHibernateTemplate().getSessionFactory().openSession().get(Book.class, id);
        book.setTitle(title);
        getHibernateTemplate().update(book);
    }

    @Transactional
    public void delete(Book book)
    {
        getHibernateTemplate().delete(book);
    }

}

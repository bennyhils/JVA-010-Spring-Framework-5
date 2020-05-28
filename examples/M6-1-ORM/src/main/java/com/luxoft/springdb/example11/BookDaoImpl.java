package com.luxoft.springdb.example11;

import com.luxoft.springdb.Book;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookDaoImpl extends AbstractHibernateDao<Book>
{

    public BookDaoImpl()
    {
        setClazz(Book.class);
    }

    @Transactional
    public void update(int id, String title)
    {
        Book book = getHibernateTemplate().getSessionFactory().openSession().get(Book.class, id);
        book.setTitle(title);
        getHibernateTemplate().update(book);


    }

    public Book findByProperty(String bookTitle)
    {
        return (Book) getHibernateTemplate()
                .findByCriteria(DetachedCriteria.forClass(Book.class)
                        .add(Restrictions.ilike("title", bookTitle)))
                .get(0);
    }
}

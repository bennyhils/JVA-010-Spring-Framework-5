package com.luxoft.jva010.orm;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luxoft.jva010.data.repositories.JpaBookDao;
import com.luxoft.jva010.orm.model.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class JpaBookDaoTest {

    private Book exampleBook = new Book("Java", Date.valueOf(LocalDate.of(2015, 5, 1)));

    @Autowired
    private JpaBookDao jpaBookDao;

    @Test
    public void testSaveBooks() {

        jpaBookDao.save(exampleBook);

        List<Book> booksList = jpaBookDao.findAll();

        assertEquals(1, booksList.size());
        assertEquals(exampleBook, booksList.get(0));

        jpaBookDao.save(new Book("Spring", Date.valueOf(LocalDate.of(2015, 5, 1))));

        jpaBookDao.save(new Book("Spring Data", Date.valueOf(LocalDate.of(2016, 4, 1))));

        booksList = jpaBookDao.findAll();
        assertEquals(3, booksList.size());

        assertEquals(exampleBook, jpaBookDao.findByTitle("Java"));

        jpaBookDao.save(new Book("Angular", Date.valueOf(LocalDate.of(2016, 3, 1))));

        System.out.println("--> Books 2015:");
        List<Book> books2015 = jpaBookDao.findByDateReleaseBetween(Date.valueOf(LocalDate.of(2015, 1, 1)),
                Date.valueOf(LocalDate.of(2015, 12, 31)));
        books2015.forEach(System.out::println);

        System.out.println();
        System.out.println("--> Books sorted by title:");
        List<Book> books = jpaBookDao.findAllByOrderByTitleAsc();
        books.stream().map(book -> book.getTitle()).forEach(System.out::println);

        System.out.println();
        System.out.println("--> Latest book:");
        System.out.println(jpaBookDao.getLatestBook());
    }


}

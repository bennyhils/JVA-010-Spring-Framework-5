package com.luxoft.jva010.orm;

import com.luxoft.jva010.data.repositories.CrudBookDao;
import com.luxoft.jva010.orm.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class CrudBookDaoTest {

    private Book exampleBook = new Book("Java", Date.valueOf(LocalDate.of(2015, 5, 1)));

    @Autowired
    private CrudBookDao bookDao;

    @Test
    public void testSaveBooks() {

        bookDao.save(exampleBook);

        // guava here
        List<Book> books = (List<Book>) bookDao.findAll();

        assertEquals(1, books.size());
        assertEquals(exampleBook, books.get(0));

        bookDao.save(new Book("Spring", Date.valueOf(LocalDate.of(2015, 5, 1))));

        bookDao.save(new Book("Spring Data", Date.valueOf(LocalDate.of(2016, 4, 1))));

        books = (List<Book>) bookDao.findAll();
        assertEquals(3, books.size());

        assertEquals(exampleBook, bookDao.findByTitle("Java"));

        bookDao.save(new Book("Angular", Date.valueOf(LocalDate.of(2016, 3, 1))));

        // testing interface methods

        System.out.println("--> Books 2015:");
        List<Book> books2015 = bookDao.findByDateReleaseBetween(Date.valueOf(LocalDate.of(2015, 1, 1)),
                Date.valueOf(LocalDate.of(2015, 12, 31)));
        books2015.forEach(System.out::println);

        System.out.println();
        System.out.println("--> Books sorted by title:");

        books = bookDao.findAllByOrderByTitleAsc();
        books.stream().map(book -> book.getTitle()).forEach(System.out::println);

        System.out.println();
        System.out.println("--> Latest book:");
        System.out.println(bookDao.getLatestBook());
    }


}

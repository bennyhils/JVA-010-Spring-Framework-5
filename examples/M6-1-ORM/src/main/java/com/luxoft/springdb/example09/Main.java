package com.luxoft.springdb.example09;

import java.util.List;
import com.luxoft.springdb.Book;
import com.luxoft.springdb.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static com.luxoft.springdb.Utils.displayBooks;
import static com.luxoft.springdb.Utils.createBook;

public class Main
{

    public static void main(String[] args)
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("example09/application-context.xml");

        BookDao bookDao = context.getBean(BookDao.class);
        Book book = createBook();
        bookDao.insert(book);

        List<Book> allBooks = bookDao.getAll();
        displayBooks(allBooks);


        String niceNewTitle = "New Features in Java";

        if (allBooks.size() > 0)
        {
            book = allBooks.get(0);

            System.out.println("\nUpdating book: " + book + "\n");
            bookDao.update(book.getId(), niceNewTitle);
        }

        displayBooks(bookDao.getAll());

        System.out.println("\nLooking for a book by title...\n");
        System.out.println("\nResult: " + bookDao.findByTitle(niceNewTitle));

        System.out.println("\nRemoving book: " + book + "\n ");
        bookDao.delete(book);

        displayBooks(bookDao.getAll());
    }
}

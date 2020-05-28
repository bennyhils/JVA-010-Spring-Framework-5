package com.luxoft.springdb;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Utils
{
    public static void displayBooks(List<Book> allBooks)
    {
        System.out.println("\nBooks:\n");

        if (allBooks.size() > 0)
        {
            System.out.println(allBooks);
            System.out.println("--------------------------------------------------");
            System.out.println("total books in db: " + allBooks.size());
            System.out.println("--------------------------------------------------");
        }
        else
        {
            System.out.println("--------------------------------------------------");
            System.out.println("our library is empty");
            System.out.println("--------------------------------------------------");
        }

    }

    public static Book createBook()
    {
        Book book = new Book();
        Random random = new Random();
        book.setTitle("Java " + Math.abs(random.nextInt()));
        book.setDateRelease(LocalDate.now());
        return book;
    }

}

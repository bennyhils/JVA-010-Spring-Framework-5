package com.luxoft.springdb.example08;

import java.sql.SQLException;
import java.util.Calendar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example08/application-context.xml");

		BookDaoImpl bookDaoImpl = (BookDaoImpl) context.getBean("bookDaoImpl");
		Book book = createBook();
		bookDaoImpl.dropTable();
		bookDaoImpl.createTable();
		bookDaoImpl.insert(book);

		try {
			bookDaoImpl.printAll();
		} catch (CustomException e) {
			System.out.println(((SQLException)e.getCause()).getErrorCode());
		}

		context.close();
	}

	private static Book createBook() {
		Book book = new Book();
		book.setTitle("Java");
		book.setDateRelease(Calendar.getInstance().getTime());
		return book;
	}

}

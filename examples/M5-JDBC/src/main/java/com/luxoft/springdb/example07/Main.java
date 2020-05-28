package com.luxoft.springdb.example07;

import java.util.Calendar;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.BadSqlGrammarException;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example07/application-context.xml");

		BookDaoImpl bookDaoImpl = (BookDaoImpl) context.getBean("bookDaoImpl");
		Book book = createBook();
		bookDaoImpl.dropTable();
		bookDaoImpl.createTable();
		bookDaoImpl.insert(book);

		try {
			bookDaoImpl.printAll();
		} catch (BadSqlGrammarException e) {
			e.printStackTrace();
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

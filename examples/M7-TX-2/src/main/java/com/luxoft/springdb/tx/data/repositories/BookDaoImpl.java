package com.luxoft.springdb.tx.data.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.luxoft.springdb.tx.orm.model.Book;

public class BookDaoImpl implements BookDaoCustom {
	
	@Autowired
	private BookDao bookDao;
	
	@Transactional
	@Override
	public void setPublishingHouse(String publishingHouse) {
		List<Book> all = bookDao.findAll();
		System.out.println("ABC");
		for (Book b: all) {
			b.setPublishingHouse(publishingHouse);
		}
	}

}

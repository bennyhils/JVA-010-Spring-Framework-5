package com.luxoft.jva010.orm.dao.jpa;

import org.springframework.stereotype.Repository;

import com.luxoft.jva010.orm.model.Book;

@Repository
public class BookJpaDaoImpl extends AbstractJpaDao<Book>{
	
	public BookJpaDaoImpl()
	{
		setClazz(Book.class);
	}
}

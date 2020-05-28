package com.luxoft.springdb.tx.orm.dao;

public class DuplicateBookTitleException extends RuntimeException {

	public DuplicateBookTitleException(String message) {
		super(message);
	}
	
	
}

package com.luxoft.springdb.example05;

import java.util.Date;

public class Book {
	private int id;
	private String title;
	private Date dateRelease;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getDateRelease() {
		return dateRelease;
	}
	
	public void setDateRelease(Date dateRelease) {
		this.dateRelease = dateRelease;
	}
	
	@Override
	public String toString() {
		return id + " " + title + " " + dateRelease;
	}
	
}

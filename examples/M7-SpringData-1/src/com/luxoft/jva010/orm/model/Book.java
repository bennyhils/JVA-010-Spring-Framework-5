package com.luxoft.jva010.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "BOOK")
public class Book implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "TITLE")
	private String title;

	@Column(name="DATE_RELEASE")
	private Date dateRelease;

	public Book() {
	}

	public Book(int id, String title, Date dateRelease) {
		this.id = id;
		this.title = title;
		this.dateRelease = dateRelease;
	}

	public Book(String title, Date dateRelease) {
		this.title = title;
		this.dateRelease = dateRelease;
	}

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

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Book book = (Book) o;

		if (dateRelease != null ? !dateRelease.equals(book.dateRelease)
				: book.dateRelease != null)
			return false;
		if (title != null ? !title.equals(book.title) : book.title != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result = 0;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (dateRelease != null ? dateRelease.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", dateRelease="
				+ dateRelease + "]";
	}


}

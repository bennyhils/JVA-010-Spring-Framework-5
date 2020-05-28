package com.luxoft.jva010.orm.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book implements Serializable
{

    private int id;
    private String title;
    private LocalDate dateRelease;

    public Book()
    {
    }

    public Book(String title, LocalDate dateRelease)
    {
        this.title = title;
        this.dateRelease = dateRelease;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Column(name = "TITLE")
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    @Column(name = "DATE_RELEASE")
    public LocalDate getDateRelease()
    {
        return dateRelease;
    }

    public void setDateRelease(LocalDate dateRelease)
    {
        this.dateRelease = dateRelease;
    }

    @Override
    public boolean equals(Object obj)
    {
        return title.equals(((Book) obj).title);
    }

    @Override
    public String toString()
    {
        return id + ":" + title + ", released " + dateRelease;
    }
}

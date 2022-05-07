package com.example.demo.Model;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int book_id;
    private  String title ;
    @OneToOne(cascade= CascadeType.ALL)
    private  Author author;

    public Author getAuthor() {
        return author;
    }

    public Book()
    {
    }
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}

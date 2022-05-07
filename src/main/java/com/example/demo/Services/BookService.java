package com.example.demo.Services;

import com.example.demo.Model.Book;
import com.example.demo.Model.Test;
import com.example.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public void AddBook(Book book) {
        bookRepository.save(book);
    }


    public List<Book> getAllBook() {
            ArrayList<Book> book = new ArrayList<>();
            bookRepository.findAll().forEach(book::add);
            return book;
    }
    public  List<Book> UpdateBook(Book book) {
        bookRepository.save(book);
        ArrayList<Book> bok = new ArrayList<>();
        bookRepository.findAll().forEach(bok::add);
        return bok;
    }

    public List<Book> deleteBook(Book book) {
        bookRepository.deleteById(book.getBook_id());
        ArrayList<Book> bok = new ArrayList<>();
        bookRepository.findAll().forEach(bok::add);
        return bok;
    }

}

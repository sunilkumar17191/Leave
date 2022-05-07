package com.example.demo.Controller;

import com.example.demo.Model.Book;
import com.example.demo.Model.userDetails;
import com.example.demo.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Mapping {
    @Autowired public BookService bookService;
@PostMapping("/AddBook")
    public List addBook(@RequestBody Book book)
{
    ArrayList<Book> list = new ArrayList<>();
    bookService.AddBook(book);
    return list;
}
    @GetMapping("/getAllBook")
    public List getAllBook()
    {
        ArrayList<Book> list = new ArrayList<>();
      //  bookService.getAllBook();
        return bookService.getAllBook();
    }
    //------------------Update User-------------------------
    @PostMapping("/updateBook")
    public List<Book> UpdateUser(@RequestBody Book book)
    {
        ArrayList<Book> list = new ArrayList<>();
        list= (ArrayList<Book>) bookService.UpdateBook(book);
        return list;
    }
    @DeleteMapping("/deleteBook")
    public List<Book> deleteBook(@RequestBody Book book)
    {
        ArrayList<Book> list = new ArrayList<>();
        list= (ArrayList<Book>) bookService.deleteBook(book);
        return list;
    }
}


package com.example.Book_Store.controller;

import com.example.Book_Store.model.Book;
import com.example.Book_Store.repository.BookRepository;
import com.example.Book_Store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/")
    public String greeting() {
        return "Hello, World";
    }
    @PostMapping(value = "/createBooks")
    public void createBook(@RequestBody Book book) {
        bookService.insertEmployee(book);

    }
    @PutMapping(value = "/updateBooks")
    public void updateBook(@RequestBody Book book) {
        bookService.saveOrUpdate(book);

    }

    @DeleteMapping(value = "/deleteEmpById")
    public void deleteBook(@RequestBody Book book) {
        bookService.deleteEmployee(book);

    }

}

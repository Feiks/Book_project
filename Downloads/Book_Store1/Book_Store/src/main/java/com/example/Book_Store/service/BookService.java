package com.example.Book_Store.service;

import com.example.Book_Store.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> findAll();

    void insertEmployee(Book book);

    Book updateEmployee(Book book);

    void executeUpdateEmployee(Book book);

    public void deleteEmployee(Book book);

    Book getBBookById(long id);

    void saveOrUpdate(Book book);
}

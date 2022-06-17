package com.example.Book_Store.service;

import com.example.Book_Store.model.Book;
import com.example.Book_Store.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void insertEmployee(Book book) {
        bookRepository.save(book);
    }

    private Book getBooks(@PathVariable("bookid") int bookid)
    {
        return bookService.getBBookById(bookid);
    }

    @Override
    public Book updateEmployee(@RequestBody Book book) {
        bookService.saveOrUpdate(book);
        return book;
    }

    @Override
    public void executeUpdateEmployee(Book book) {

    }

    @Override
    public void deleteEmployee(Book book) {
    bookRepository.deleteById(book.getId());

    }

    @Override
    public Book getBBookById(long id) {
        return null;
    }

    @Override
    public void saveOrUpdate(Book book) {
        bookRepository.save(book);

    }

    public Book getBooksById(long id)
    {
        return bookRepository.findById(id).get();
    }
}

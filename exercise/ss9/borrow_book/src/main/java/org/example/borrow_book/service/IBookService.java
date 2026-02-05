package org.example.borrow_book.service;

import org.example.borrow_book.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    String borrowBook(int id);
    void returnBook(String borrowCode);
}

package org.example.borrow_book.controller;

import org.example.borrow_book.exception.InvalidBorrowTransferException;
import org.example.borrow_book.exception.OutOfBookException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OutOfBookException.class)
    public String outOfBook() {
        return "error/out_of_book";
    }

    @ExceptionHandler(InvalidBorrowTransferException.class)
    public String invalidCode() {
        return "error/invalid_code";
    }
}


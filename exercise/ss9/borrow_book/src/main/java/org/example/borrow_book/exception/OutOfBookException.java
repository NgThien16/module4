package org.example.borrow_book.exception;

public class OutOfBookException extends RuntimeException {
    public OutOfBookException(String message) {
        super(message);
    }
}

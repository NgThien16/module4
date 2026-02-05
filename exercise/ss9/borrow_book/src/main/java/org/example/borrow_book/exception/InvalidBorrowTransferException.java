package org.example.borrow_book.exception;

public class InvalidBorrowTransferException extends RuntimeException {
    public InvalidBorrowTransferException(String message) {
        super(message);
    }
}

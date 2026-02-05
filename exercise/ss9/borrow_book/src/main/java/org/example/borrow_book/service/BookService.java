package org.example.borrow_book.service;

import org.example.borrow_book.entity.Book;
import org.example.borrow_book.entity.BorrowTransfer;
import org.example.borrow_book.repository.IBookRepository;
import org.example.borrow_book.repository.IBorrowTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IBorrowTransferRepository borrowTransferRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public String borrowBook(int bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sách"));

        if (book.getQuantity() <= 0) {
            throw new RuntimeException("Sách đã hết");
        }

        // giảm số lượng sách
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        // sinh mã mượn 5 chữ số
        String borrowCode = String.format("%05d", new Random().nextInt(100000));

        BorrowTransfer transfer = new BorrowTransfer();
        transfer.setBorrowCode(borrowCode);
        transfer.setBook(book);
        transfer.setReturned(false);

        borrowTransferRepository.save(transfer);

        return borrowCode;
    }

    @Override
    public void returnBook(String borrowCode) {
        BorrowTransfer transfer = borrowTransferRepository.findByBorrowCode(borrowCode)
                .orElseThrow(() -> new RuntimeException("Mã mượn không hợp lệ"));

        if (transfer.isReturned()) {
            throw new RuntimeException("Mã này đã được trả");
        }

        Book book = transfer.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);

        transfer.setReturned(true);
        borrowTransferRepository.save(transfer);
    }
}

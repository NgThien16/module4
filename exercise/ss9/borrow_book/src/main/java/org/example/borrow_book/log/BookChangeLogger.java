package org.example.borrow_book.log;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookChangeLogger {

    @AfterReturning("execution(* org.example.borrow_book.service.BookService.borrowBook(..))")
    public void logBorrow() {
        System.out.println("[LOG] Một cuốn sách đã được mượn");
    }

    @AfterReturning("execution(* org.example.borrow_book.service.BookService.returnBook(..))")
    public void logReturn() {
        System.out.println("[LOG] Một cuốn sách đã được trả");
    }
}

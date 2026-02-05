package org.example.borrow_book.log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VisitorLogger {

    private int visitorCount = 0;

    @Before("execution(* org.example.borrow_book.controller.*.*(..))")
    public void countVisitor() {
        visitorCount++;
        System.out.println("[VISITOR] Lượt truy cập thư viện: " + visitorCount);
    }
}


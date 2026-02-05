package org.example.borrow_book.controller;

import org.example.borrow_book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    // Danh sách sách
    @GetMapping
    public String showList(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book/list";
    }

    // Chi tiết sách
    @GetMapping("/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        model.addAttribute("bookId", id);
        return "book/detail";
    }

    // Mượn sách
    @PostMapping("/borrow")
    public String borrowBook(@RequestParam int bookId, Model model) {
        String borrowCode = bookService.borrowBook(bookId);
        model.addAttribute("borrowCode", borrowCode);
        return "book/borrow-success";
    }

    // Form trả sách
    @GetMapping("/return")
    public String showReturnForm() {
        return "book/return";
    }

    // Xử lý trả sách
    @PostMapping("/return")
    public String returnBook(@RequestParam String borrowCode) {
        bookService.returnBook(borrowCode);
        return "redirect:/books";
    }
}

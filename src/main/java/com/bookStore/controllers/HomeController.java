package com.bookStore.controllers;

import com.bookStore.BookStore;

import com.bookStore.patterns.Factory.ExampleBook;
import com.bookStore.patterns.Factory.RegularBook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    BookStore bookStore = new BookStore();

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("bookList", bookStore.getBookList());
        return "index";
    }

    @GetMapping("/add")
    public String addBookMenu(Model model) {
        model.addAttribute("book", new ExampleBook());
        return "addBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") ExampleBook book) {
        System.out.println(book.type);
        bookStore.addBook(book);
        return "redirect:/";
    }
}

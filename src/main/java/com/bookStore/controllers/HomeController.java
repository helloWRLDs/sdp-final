package com.bookStore.controllers;

import com.bookStore.BookStore;

import com.bookStore.entity.BookStruct;
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
        model.addAttribute("book", new BookStruct());
        return "addBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") BookStruct book) {
        bookStore.addBook(book);
        return "redirect:/";
    }
}

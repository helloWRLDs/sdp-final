package com.bookStore.controllers;

import com.bookStore.BookStoreInstance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    BookStoreInstance bookStore = new BookStoreInstance();
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("bookList", bookStore.getBookList());
        return "index";
    }
}

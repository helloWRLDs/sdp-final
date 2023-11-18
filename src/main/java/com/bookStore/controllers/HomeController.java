package com.bookStore.controllers;

import com.bookStore.dao.BookDAO;
import com.bookStore.patterns.Factory.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(Model model) {
        List<Book> bookList = BookDAO.getAllBooks();
        model.addAttribute("bookList", bookList);
        return "index";
    }
}

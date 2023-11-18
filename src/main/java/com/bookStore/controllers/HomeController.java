package com.bookStore.controllers;

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
        List<Book> bookList = new ArrayList<>();
        bookList.add(new ScienceBook(0, "some title", "some descr", 100));
        model.addAttribute("bookList", bookList);
        return "index";
    }
}

package com.bookStore.patterns.Observer;

import com.bookStore.controllers.*;
import com.bookStore.patterns.Factory.Book;

import java.util.List;

public interface Observer {
    void handleEvent(List<Book> bookList);
}

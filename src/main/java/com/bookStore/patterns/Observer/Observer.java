package com.bookStore.patterns.Observer;

import com.bookStore.entity.Book;

import java.util.List;

public interface Observer {
    void handleEvent(List<Book> bookList);
}

package org.example.Observer;

import org.example.Factory.Book;

import java.util.List;

public interface Observer {
    void handleEvent(List<Book> bookList);
}

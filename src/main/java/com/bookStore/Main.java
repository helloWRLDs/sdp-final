package com.bookStore;

import com.bookStore.dao.BookDAO;
import com.bookStore.patterns.Factory.Book;
import com.bookStore.patterns.Observer.Subscriber;
import com.bookStore.patterns.Singleton.Database;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookStoreInstance bookStore = new BookStoreInstance();
        bookStore.addObserver(new Subscriber("Vova"));
        List<Book> bookList = bookStore.getBookList();
        for (Book book : bookList) {
            System.out.println(book.getTitle());
        }
    }
}

package com.bookStore;

import com.bookStore.patterns.Factory.Book;
import com.bookStore.patterns.Observer.Subscriber;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        bookStore.addObserver(new Subscriber("Vova"));
        List<Book> bookList = bookStore.getBookList();
        for (Book book : bookList) {
            System.out.println(book.getTitle());
        }
    }
}

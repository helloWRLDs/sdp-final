package com.bookStore;

import com.bookStore.patterns.Singleton.BookRepository;
import com.bookStore.patterns.Factory.Book;
import com.bookStore.patterns.Observer.Observed;
import com.bookStore.patterns.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class BookStore implements Observed {
    List<Observer> subscribers = new ArrayList<>();
    List<Book> bookList = new ArrayList<>();

    public BookStore() {
        bookList = BookRepository.getAllBooks();
    }

    public List<Book> getBookList() {
        notifyObservers();
        return bookList;
    }

    @Override
    public void addObserver(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : subscribers) {
            observer.handleEvent(bookList);
        }
    }
}

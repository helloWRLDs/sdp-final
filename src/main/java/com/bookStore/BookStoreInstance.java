package com.bookStore;

import com.bookStore.dao.BookDAO;
import com.bookStore.patterns.Factory.Book;
import com.bookStore.patterns.Observer.Observed;
import com.bookStore.patterns.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class BookStoreInstance implements Observed {
    List<Observer> subscribers = new ArrayList<>();
    List<Book> bookList = new ArrayList<>();

    public BookStoreInstance() {
        bookList = BookDAO.getAllBooks();
    }

    public List<Book> getBookList() {
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

package com.bookStore;

import com.bookStore.patterns.Factory.BookFactory;
import com.bookStore.patterns.Factory.ConcreteBookFactory;
import com.bookStore.patterns.Factory.ExampleBook;
import com.bookStore.patterns.Singleton.BookRepository;
import com.bookStore.patterns.Factory.Book;
import com.bookStore.patterns.Observer.Observed;
import com.bookStore.patterns.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class BookStore implements Observed {
    List<Observer> subscribers = new ArrayList<>();
    List<Book> bookList = new ArrayList<>();
    BookFactory factory = new ConcreteBookFactory();

    public BookStore() {
        bookList = BookRepository.getAllBooks();
    }

    public List<Book> getBookList() {
        notifyObservers();
        return bookList;
    }

    public void addBook(ExampleBook exampleBook) {

        System.out.println(exampleBook.title);
        System.out.println(exampleBook.description);
        System.out.println(exampleBook.price);
        System.out.println(exampleBook.type);

        Book newBook = factory.createBook(exampleBook.getTitle(), exampleBook.getDescription(), exampleBook.getPrice(), exampleBook.getType());
        BookRepository.insertBook(newBook);
        bookList = getBookList();
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

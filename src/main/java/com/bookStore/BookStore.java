package com.bookStore;

import com.bookStore.entity.Book;
import com.bookStore.entity.BookStruct;
import com.bookStore.patterns.Factory.DecoratorFactory;
import com.bookStore.patterns.Singleton.BookRepository;
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
        bookList = BookRepository.getAllBooks();
        notifyObservers();
        return bookList;
    }

    public void addBook(BookStruct bookStruct) {
        DecoratorFactory factory = new DecoratorFactory();
        Book newBook = new Book();
        newBook.setTitle(bookStruct.title);
        newBook.setDescription(bookStruct.description);
        newBook.setPrice(bookStruct.price);
        for (int i = 0; i < bookStruct.tags.length; i++) {;
            if (bookStruct.tags[i] != null) {
                newBook = factory.bookWithDecorator(bookStruct.tags[i], newBook);
            }
        }
        BookRepository.insertBook(newBook);
        bookList = BookRepository.getAllBooks();
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

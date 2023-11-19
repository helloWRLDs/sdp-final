package com.bookStore;

import com.bookStore.entity.Book;
import com.bookStore.entity.BookStruct;
import com.bookStore.patterns.Factory.DecoratorFactory;
import com.bookStore.patterns.Singleton.BookRepository;
import com.bookStore.patterns.Observer.Observed;
import com.bookStore.patterns.Observer.Observer;
import com.bookStore.patterns.Strategy.BlackFridayDiscount;
import com.bookStore.patterns.Strategy.HolidayDiscount;

import java.util.ArrayList;
import java.util.List;

public class BookStore implements Observed {
    List<Observer> subscribers = new ArrayList<>();
    List<Book> bookList = new ArrayList<>();

    public BookStore() {
        bookList = BookRepository.getAllBooks();
    }

    public List<Book> updateBookList() {
        bookList = BookRepository.getAllBooks();
        return bookList;
    }

    public List<Book> getBookList() {
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
        bookList = updateBookList();
        notifyObservers();
    }

    public Book getBookById(int id) {
        for (Book book : bookList) {
            if (id == book.getId()) {
                return book;
            }
        }
        return null;
    }

    public void applyDiscount(int id, String discount) {
        if (discount.equalsIgnoreCase("holiday")) {
            bookList.get(id - 1).setStrategy(new HolidayDiscount());
        } else {
            bookList.get(id - 1).setStrategy(new BlackFridayDiscount());
        }
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

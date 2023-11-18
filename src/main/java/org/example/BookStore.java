package org.example;

import org.example.Factory.Book;
import org.example.Factory.EducationalBook;
import org.example.Observer.Observed;
import org.example.Observer.Observer;
import org.example.Strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

public class BookStore implements Observed {
    List<Observer> subscribers = new ArrayList<>();
    List<Book> bookStorage = new ArrayList<>();

    public void addBook(String title, String description, int price) {
        bookStorage.add(new EducationalBook(title, description, price));
        notifyObservers();
    }

    public Book findBook(String title) {
        for (int i = 0; i < bookStorage.size(); i++) {
            if (bookStorage.get(i).getTitle().equalsIgnoreCase(title)) {
                return bookStorage.get(i);
            }
        }
    }

    public void createOrder() {
        List<Book> order = new ArrayList<>();
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
            observer.handleEvent(bookStorage);
        }
    }
}

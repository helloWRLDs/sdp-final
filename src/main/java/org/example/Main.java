package org.example;

import org.example.Observer.Subscriber;
import org.example.Singleton.Database;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        BookStore bookStore = new BookStore();
        bookStore.addObserver(new Subscriber("Vasya"));
        bookStore.addObserver(new Subscriber("Vova"));
        bookStore.addBook("123", "123", 53);
    }
}
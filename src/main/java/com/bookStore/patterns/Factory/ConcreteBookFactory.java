package com.bookStore.patterns.Factory;

public class ConcreteBookFactory implements BookFactory{
    @Override
    public Book createBook(String title, String description, int price, String type) {
        return switch (type) {
            case "a" -> new AudioBook(0, title, description, price);
            case "r" -> new RegularBook(0, title, description, price);
            case "e" -> new EBook(0, title, description, price);
            case null -> new RegularBook(0, title, description, price);
            default -> null;
        };
    }
}

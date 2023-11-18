package com.bookStore.patterns.Factory;

public class ConcreteBookFactory implements BookFactory{
    @Override
    public Book createBook(String title, String description, int price, String type) {
        switch (type) {
            case "a":
                return new AudioBook(0, title, description, price);
            case "r":
                return new RegularBook(0, title, description, price);
            case "e":
                return new EBook(0, title, description, price);
            default:
                return null;
        }
    }
}

package com.bookStore.patterns.Factory;

public class EBookFactory extends BookFactory{
    @Override
    Book createBook(String title, String description, int price) {
        return new EBook(title, description, price);
    }
}

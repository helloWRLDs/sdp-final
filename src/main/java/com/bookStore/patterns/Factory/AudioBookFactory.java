package com.bookStore.patterns.Factory;

public class AudioBookFactory extends BookFactory{
    @Override
    Book createBook(String title, String description, int price) {
        return new AudioBook(title, description, price);
    }
}

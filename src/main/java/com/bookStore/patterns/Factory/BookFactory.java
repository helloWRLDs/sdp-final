package com.bookStore.patterns.Factory;

public interface BookFactory {
    Book createBook(String title, String description, int price, String type);
}

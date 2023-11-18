package com.bookStore.patterns.Factory;

public interface BookFactory {
    public Book createBook(String title, String description, int price);
}

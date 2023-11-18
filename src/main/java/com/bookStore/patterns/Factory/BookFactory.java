package com.bookStore.patterns.Factory;

abstract class BookFactory {
    abstract Book createBook(String title, String description, int price);
}

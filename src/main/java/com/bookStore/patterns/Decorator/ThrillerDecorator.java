package com.bookStore.patterns.Decorator;

import com.bookStore.entity.Book;

public class ThrillerDecorator extends TagsDecorator{
    public ThrillerDecorator(Book book) {
        this.book = book;
        this.code = "thriller";
    }

    @Override
    public String getTags() {
        return book.getTags() + " Thriller";
    }
}

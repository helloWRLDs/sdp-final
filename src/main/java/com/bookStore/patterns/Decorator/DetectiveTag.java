package com.bookStore.patterns.Decorator;

import com.bookStore.entity.Book;

public class DetectiveTag extends TagsDecorator{
    public DetectiveTag(Book book) {
        this.book = book;
        this.code = "detective";
    }

    @Override
    public String getTags() {
        return book.getTags() + " Detective";
    }
}

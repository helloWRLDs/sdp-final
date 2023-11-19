package com.bookStore.patterns.Decorator;

import com.bookStore.entity.Book;

public class DramaTag extends TagsDecorator{
    public DramaTag(Book book) {
        this.book = book;
        this.code = "drama";
    }

    @Override
    public String getTags() {
        return book.getTags() + " Drama";
    }
}

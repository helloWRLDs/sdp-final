package com.bookStore.patterns.Decorator;

import com.bookStore.entity.Book;

public class MysteryTag extends TagsDecorator{
    public MysteryTag(Book book) {
        this.book = book;
        this.code = "mystery";
    }

    @Override
    public String getTags() {
        return book.getTags() + " Mystery";
    }
}

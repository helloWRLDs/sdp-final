package com.bookStore.patterns.Decorator;

import com.bookStore.entity.Book;

public class HistoryTag extends TagsDecorator{
    public HistoryTag(Book book) {
        this.book = book;
        this.code = "history";
    }

    @Override
    public String getTags() {
        return book.getTags() + " History";
    }
}

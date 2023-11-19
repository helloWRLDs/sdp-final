package com.bookStore.patterns.Factory;

import com.bookStore.entity.Book;
import com.bookStore.entity.BookStruct;
import com.bookStore.patterns.Decorator.TagsDecorator;

public interface Factory {
    TagsDecorator bookWithDecorator(String code, Book book);
}

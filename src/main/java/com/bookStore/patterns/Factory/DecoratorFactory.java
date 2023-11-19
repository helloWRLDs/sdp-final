package com.bookStore.patterns.Factory;

import com.bookStore.entity.Book;
import com.bookStore.patterns.Decorator.*;

public class DecoratorFactory implements Factory{

    @Override
    public TagsDecorator bookWithDecorator(String code, Book book) {
        switch (code.toLowerCase()) {
            case "mystery": return new MysteryTag(book);
            case "detective": return new DetectiveTag(book);
            case "drama": return new DramaTag(book);
            case "history": return new HistoryTag(book);
            case "thriller": return new ThrillerDecorator(book);
            default: return null;
        }
    }
}

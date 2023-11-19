package com.bookStore.patterns.Decorator;

import com.bookStore.entity.Book;

public abstract class TagsDecorator extends Book{
    String code;
    Book book;
    public abstract String getTags();

    public String getTitle() {
        return book.getTitle();
    }
    public void setTitle(String title) {
        book.setTitle(title);
    }
    public String getDescription() {
        return book.getDescription();
    }
    public void setDescription(String description) {
        book.setDescription(description);
    }
    public int getPrice() {
        return book.getPrice();
    }
    public void setPrice(int price) {
        book.setPrice(price);
    }
    public int getId() {
        return book.getId();
    }
    public void setId(int id) {
        book.setId(id);
    }
}

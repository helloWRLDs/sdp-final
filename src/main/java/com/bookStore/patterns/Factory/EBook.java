package com.bookStore.patterns.Factory;

public class EBook implements Book {
    private String title;
    private String description;
    private int price;


    public EBook(String title, String description, int price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getPrice() {
        return price;
    }
}

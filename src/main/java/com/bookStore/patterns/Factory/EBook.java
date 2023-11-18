package com.bookStore.patterns.Factory;

public class EBook implements Book {
    private int id;
    private String title;
    private String description;
    private int price;

    public EBook(int id, String title, String description, int price) {
        this.id = id;
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
        return this.title;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getType() {
        return "e";
    }
}
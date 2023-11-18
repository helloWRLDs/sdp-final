package com.bookStore.patterns.Factory;



public class AudioBook implements Book {
    private int id;
    private String title;
    private String description;
    private int price;

    public AudioBook(int id, String title, String description, int price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getType() {
        return "a";
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

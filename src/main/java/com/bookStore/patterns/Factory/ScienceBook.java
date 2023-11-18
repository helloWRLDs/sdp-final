package com.bookStore.patterns.Factory;

public class ScienceBook implements Book{
    private int id;
    private String title;
    private String description;
    private double price;


    public ScienceBook(int id, String title, String description, int price) {
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
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

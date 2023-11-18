package com.bookStore.patterns.Factory;

public class EducationalBook implements Book{
    private int id;
    private String title;
    private String description;
    private double price;


    public EducationalBook(int id, String title, String description, double price) {
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
        return this.title;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}

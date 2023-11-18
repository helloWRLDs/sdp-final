package org.example.Factory;

import org.example.Strategy.Strategy;

public class EducationalBook implements Book{
    private String title;
    private String description;
    private double price;
    private Strategy strategy;


    public EducationalBook(String title, String description, int price, ) {
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

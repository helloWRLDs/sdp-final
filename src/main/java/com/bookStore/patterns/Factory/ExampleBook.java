package com.bookStore.patterns.Factory;

public class ExampleBook implements Book{
    public String description;
    public String title;
    public int price;
    public String type;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
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
        return 0;
    }

    @Override
    public String getType() {
        return this.type;
    }
}

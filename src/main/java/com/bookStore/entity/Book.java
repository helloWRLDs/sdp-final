package com.bookStore.entity;


import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String description;
    private int price;
    private int id;
    private String tags = "";

    public String toString() {
        return String.format("%s: %s  \ntags: %s \nprice: %d$\n", getTitle(), getDescription(), getTags(), getPrice());
    }

    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}

package com.bookStore.entity;

public class BookStruct {
    public String title;
    public String description;
    public String[] tags;
    public int price;

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

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tag) {
        tags = new String[tag.length];
        for (int i = 0; i < this.tags.length; i++) {
            tags[i] = tag[i];
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public BookStruct() {
        tags = new String[5];
    }

    public String toString() {
        for (String tag : tags) {
            System.out.print(tag);
        }
        return String.format("title: %s  description: %s  price: %d\n", title, description, price);
    }
}

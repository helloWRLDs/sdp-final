package com.bookStore.patterns.Strategy;
import com.bookStore.patterns.Factory.Book;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Book> books = new ArrayList<>();
    private double totalPrice;
    private Strategy shipping;

    public void addBook(Book book) {
        books.add(book);
        totalPrice += book.getPrice();
    }

    public void setShipping(Strategy Shipping) {
        this.shipping = Shipping;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double calculateShippingCost() {
        return shipping.calculateShippingCost(this);
    }
}

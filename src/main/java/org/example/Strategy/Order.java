package org.example.Strategy;
import org.example.Factory.*;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Book> books = new ArrayList<>();
    private double totalPrice;
    private Strategy Shipping;

    public void addBook(Book book) {
        books.add(book);
        totalPrice += book.getPrice();
    }
    public void setShipping(Strategy Shipping) {
        this.Shipping = Shipping;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public double calculateShippingCost() {
        return Shipping.calculateShippingCost(this);
    }
}

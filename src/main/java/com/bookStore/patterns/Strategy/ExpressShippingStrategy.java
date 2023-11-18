package com.bookStore.patterns.Strategy;

public class ExpressShippingStrategy implements Strategy{
    @Override
    public double calculateShippingCost(Order order) {
        return order.getTotalPrice() * 1;
    }
}

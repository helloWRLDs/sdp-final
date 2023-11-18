package org.example.Strategy;

public class StandardShipping implements Strategy{
    @Override
    public double calculateShippingCost(Order order) {
        return order.getTotalPrice() * 0.5;
    }
}



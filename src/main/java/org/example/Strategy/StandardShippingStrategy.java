package org.example.Strategy;

public class StandardShippingStrategy implements Strategy{
    @Override
    public double calculateShippingCost(Order order) {
        return order.getTotalPrice() * 0.5;
    }
}



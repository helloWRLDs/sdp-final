package org.example.Strategy;

public class ExpressShipping implements Strategy{
    @Override
    public double calculateShippingCost(Order order) {
        return order.getTotalPrice() * 1;
    }
}

package com.bookStore.patterns.Strategy;

public class BlackFridayDiscount implements Strategy{
    @Override
    public double applyDiscount(int totalPrice) {
        return totalPrice * 0.5;
    }
}

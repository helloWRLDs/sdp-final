package com.bookStore.patterns.Strategy;

public class HolidayDiscount implements Strategy{
    @Override
    public double applyDiscount(int totalPrice) {
        return totalPrice * 0.8;
    }
}

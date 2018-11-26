package com.THR.DesignPatterns.������ģʽ2;

public class Price {

    private MemberStrategy strategy;

    public Price(MemberStrategy strategy) {
        this.strategy = strategy;
    }

    public double quote(double bookPrice) {
        return strategy.calcPrice(bookPrice);
    }
}

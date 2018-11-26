package com.THR.DesignPatterns.装饰者模式;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}

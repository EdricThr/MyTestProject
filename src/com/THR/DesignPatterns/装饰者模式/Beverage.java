package com.THR.DesignPatterns.装饰者模式;

public abstract class Beverage {

    String description = "Unknown beverage";

    public String getDescription() {
        return description;
    }

    public abstract  double cost();
}

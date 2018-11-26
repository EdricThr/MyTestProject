package com.THR.DesignPatterns.建造者模式KFC;

public interface MealBuilder {

    void buildFood();
    void buildDrink();

    Meal getMeal();
}

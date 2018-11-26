package com.THR.DesignPatterns.建造者模式KFC;

public class KfcWaiter {

    private MealBuilder mealBuilder;

    public KfcWaiter(MealBuilder mealBuilder) {
        this. mealBuilder = mealBuilder;
    }

    public void prepareMeal() {
        mealBuilder.buildFood();
        mealBuilder.buildDrink();
    }

}

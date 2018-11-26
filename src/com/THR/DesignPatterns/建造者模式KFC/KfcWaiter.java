package com.THR.DesignPatterns.������ģʽKFC;

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

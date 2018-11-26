package com.THR.DesignPatterns.������ģʽKFC;

public class SubMealBuilderA implements  MealBuilder {

    private Meal meal = new Meal();

    @Override
    public void buildFood() {
        meal.setFood("ը��");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("����");
    }

    @Override
    public Meal getMeal() {
        return meal;
    }
}

package com.THR.DesignPatterns.建造者模式KFC;

public class SubMealBuilderA implements  MealBuilder {

    private Meal meal = new Meal();

    @Override
    public void buildFood() {
        meal.setFood("炸鸡");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("可乐");
    }

    @Override
    public Meal getMeal() {
        return meal;
    }
}

package com.THR.DesignPatterns.������ģʽKFC;

public class Client_JianZaoKfc {


    public static void main(String args[]){

        MealBuilder mealBuilder = new SubMealBuilderA();

        KfcWaiter waiter = new KfcWaiter(mealBuilder);

        waiter.prepareMeal();

        Meal meal = mealBuilder.getMeal();
        System.out.println(meal.getFood());
        System.out.println(meal.getDrink());
    }


}

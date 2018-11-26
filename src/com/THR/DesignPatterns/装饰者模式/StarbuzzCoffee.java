package com.THR.DesignPatterns.装饰者模式;

/**
 * 主程序
 * 装饰者模式也就是传递对象，一层一层的调用
 */
public class StarbuzzCoffee {

    public static void main(String args[]){
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $ " +beverage.cost());

        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription() + " $ " +beverage.cost());
    }
}

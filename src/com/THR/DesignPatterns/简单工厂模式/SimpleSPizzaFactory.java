package com.THR.DesignPatterns.简单工厂模式;

public class SimpleSPizzaFactory {

    public SPizza createSPizza(String type) {
        if (null == type) {
            return null;
        }
        SPizza sPizza = null;
        if ("MySPizza".equalsIgnoreCase(type)) {
            sPizza = new MySPizza();
        }
        return sPizza;
    }
}

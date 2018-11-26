package com.THR.DesignPatterns.�򵥹���ģʽ;

public class SPizzaStore {

    private SimpleSPizzaFactory simpleSPizzaFactory;

    public SPizzaStore(SimpleSPizzaFactory simpleSPizzaFactory) {
        this.simpleSPizzaFactory = simpleSPizzaFactory;
    }

    public SPizza orderSPizza (String type) {

        SPizza sPizza = simpleSPizzaFactory.createSPizza(type);
        if (null == sPizza) {
            return null;
        }
        sPizza.prepare();
        return  sPizza;
    }
}

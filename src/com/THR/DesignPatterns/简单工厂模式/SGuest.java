package com.THR.DesignPatterns.�򵥹���ģʽ;

public class SGuest {

    public static void main(String args[]){
        SimpleSPizzaFactory simpleSPizzaFactory = new SimpleSPizzaFactory();
        SPizzaStore sPizzaStore = new SPizzaStore(simpleSPizzaFactory);
        SPizza sPizza = sPizzaStore.orderSPizza("MySPizza");
        System.out.println(sPizza.getName());
    }
}

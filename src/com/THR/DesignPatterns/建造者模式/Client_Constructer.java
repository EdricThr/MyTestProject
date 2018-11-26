package com.THR.DesignPatterns.建造者模式;

public class Client_Constructer {
    public static void main(String args[]){
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.retrieveResult();
        System.out.println(product.getPart1());
        System.out.println(product.getPart2());
    }
}

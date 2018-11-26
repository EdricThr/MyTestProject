package com.THR.DesignPatterns.²ßÂÔÄ£Ê½1;

public class Client_CeLue1 {

    public static void main(String args[]){

        Strategy strategy = new ConcreteStrategyA();
        Context context = new Context(strategy);
        context.contextInterface();

        System.out.println("------------------");

        strategy = new ConcreteStrategyB();
        context = new Context(strategy);
        context.contextInterface();

    }
}

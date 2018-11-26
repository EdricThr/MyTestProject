package com.THR.DesignPatterns.ге╫сдёй╫;

public class Client_Qiaojie {
    public static void main(String args[]){
        Implementor concreteImplementorA = new ConcreteImplementorA();
        RefineAbstraction refineAbstraction = new RefineAbstraction(concreteImplementorA);
        refineAbstraction.otherOperation();
        refineAbstraction.operation();
        doHigh(refineAbstraction);
    }

    private static void doHigh(Abstraction refineAbstraction) {
        HighRefineAbstration highRefineAbstration = new HighRefineAbstration(refineAbstraction);
        highRefineAbstration.highOperation();
        highRefineAbstration.hightOtherOperation();
    }
}

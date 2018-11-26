package com.THR.DesignPatterns.ге╫сдёй╫;

public class RefineAbstraction extends Abstraction {

    public RefineAbstraction(Implementor impl) {
        super(impl);
    }

    @Override
    public void operation() {
        System.out.println("Override do something start....");
        super.operation();
        System.out.println("Override something end....");
    }

    public void otherOperation() {
        System.out.println("otherOperation do something start....");
        super.operation();
        System.out.println("otherOperation do something end....");
    }
}

package com.THR.DesignPatterns.ге╫сдёй╫;

public class HighRefineAbstration extends HighAbstration {

    public HighRefineAbstration(Abstraction abs) {
        super(abs);
    }

    @Override
    public void highOperation() {
        System.out.println("Override highOperation");
        super.highOperation();
        System.out.println("Override highOperation");
    }

    public void hightOtherOperation() {
        System.out.println("hightOtherOperation");
        super.highOperation();
        System.out.println("hightOtherOperation");
    }
}

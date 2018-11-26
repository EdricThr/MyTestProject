package com.THR.DesignPatterns.StatePatternOne;

public class ConcreteStateA implements State {
    @Override
    public void handle(String sampleParameter) {
        System.out.println("ConcreteStateA handle : " + sampleParameter);
    }
}
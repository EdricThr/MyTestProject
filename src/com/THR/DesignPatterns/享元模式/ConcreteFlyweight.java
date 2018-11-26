package com.THR.DesignPatterns.ÏíÔªÄ£Ê½;

public class ConcreteFlyweight implements Flyweight {

    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }


    @Override
    public void operation(String state) {
        System.out.println("IntrinsicState: " + intrinsicState);
        System.out.println("State: " + state);
    }
}

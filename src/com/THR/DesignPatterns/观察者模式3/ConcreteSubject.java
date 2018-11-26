package com.THR.DesignPatterns.观察者模式3;

public class ConcreteSubject extends Subject {
    private String state;

    public String getState() {
        return state;
    }

    public void change(String state) {
        this.state = state;
        notifyObserver(state);
    }
}

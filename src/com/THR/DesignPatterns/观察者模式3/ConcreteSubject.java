package com.THR.DesignPatterns.�۲���ģʽ3;

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

package com.THR.DesignPatterns.ге╫сдёй╫;

public abstract class Abstraction {
    private Implementor impl;

    public Abstraction (Implementor impl) {
        this.impl = impl;
    }

    public void operation() {
        impl.operationImpl();
    }
}
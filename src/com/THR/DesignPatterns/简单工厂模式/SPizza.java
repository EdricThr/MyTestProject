package com.THR.DesignPatterns.�򵥹���ģʽ;

public abstract class SPizza {
    protected String name;

    public void prepare() {
        System.out.println("Preparing pizza:" + name);
    }

    public String getName() {
        return name;
    }
}

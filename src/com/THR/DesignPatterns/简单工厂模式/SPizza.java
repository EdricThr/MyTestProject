package com.THR.DesignPatterns.简单工厂模式;

public abstract class SPizza {
    protected String name;

    public void prepare() {
        System.out.println("Preparing pizza:" + name);
    }

    public String getName() {
        return name;
    }
}

package com.THR.DesignPatterns.建造者模式;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPare1();
        builder.buildPare2();
    }
}

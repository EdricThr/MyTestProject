package com.THR.DesignPatterns.原型模式;

public interface Prototype {

    Prototype clone();
    String getName();
    void setName(String name);
}

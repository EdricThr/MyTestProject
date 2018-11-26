package com.THR.DesignPatterns.原型模式;

public class ConcretePrototype2 implements Prototype {

    private String name;
    @Override
    public Prototype clone() {
        ConcretePrototype2 prototype2 = new ConcretePrototype2();
        prototype2.setName(name);
        return prototype2;
    }


    @Override
    public String toString() {
        return "Now in Prototype2, name: " + name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

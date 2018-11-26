package com.THR.DesignPatterns.原型模式;

public class ContretePrototype1 implements Prototype {

    private String name;
    @Override
    public Prototype clone() {
        ContretePrototype1 prototype1 = new ContretePrototype1();
        prototype1.setName(name);
        return prototype1;
    }

    @Override
    public String toString() {
        return "Now in Prototype1, name: " + name;
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

package com.THR.DesignPatterns.访问者模式;

public class NodeA extends Node {
    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return "NodeA";
    }
}

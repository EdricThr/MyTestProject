package com.THR.DesignPatterns.访问者模式;

public class NodeB extends Node {
    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationB() {
        return "NodeB";
    }
}

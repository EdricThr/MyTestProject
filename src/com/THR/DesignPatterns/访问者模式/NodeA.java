package com.THR.DesignPatterns.������ģʽ;

public class NodeA extends Node {
    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return "NodeA";
    }
}

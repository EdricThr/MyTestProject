package com.THR.DesignPatterns.������ģʽ;

public class NodeB extends Node {
    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationB() {
        return "NodeB";
    }
}

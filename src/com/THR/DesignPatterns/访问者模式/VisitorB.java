package com.THR.DesignPatterns.访问者模式;

public class VisitorB implements Visitor {
    @Override
    public void visit(NodeA node) {
        System.out.println(node.operationA());
    }

    @Override
    public void visit(NodeB node) {
        System.out.println(node.operationB());
    }
}

package com.THR.DesignPatterns.访问者模式;

public class Client_FangWenZhe2 {

    public static void main(String args[]){

        Visitor visitorA = new VisitorA();
        NodeA nodeA = new NodeA();
        visitorA.visit(nodeA);
    }
}

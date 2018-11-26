package com.THR.DesignPatterns.访问者模式;

public class Client_FangWenZhe {

    public static void main(String args[]){
        ObjectStructure os = new ObjectStructure();
        os.add(new NodeA());
        os.add(new NodeB());

        Visitor visitor = new VisitorA();
        os.action(visitor);
    }
}

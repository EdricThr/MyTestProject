package com.THR.DesignPatterns.组合模式;

public class Client_Composite {

    public static void main(String args[]) throws Exception {
        Composite composite = new Composite("根节点");
        composite.addComponent(new Leaf("一叶子"));
        composite.addComponent(new Leaf("二叶子"));
        composite.operation();
    }
}

package com.THR.DesignPatterns.���ģʽ;

public class Client_Composite {

    public static void main(String args[]) throws Exception {
        Composite composite = new Composite("���ڵ�");
        composite.addComponent(new Leaf("һҶ��"));
        composite.addComponent(new Leaf("��Ҷ��"));
        composite.operation();
    }
}

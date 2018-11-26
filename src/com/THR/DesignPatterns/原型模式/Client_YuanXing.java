package com.THR.DesignPatterns.ԭ��ģʽ;

public class Client_YuanXing {

    public static void main(String args[]) throws Exception {
        Prototype p1 = new ContretePrototype1();
        PrototypeManager.setPrototype("p1", p1);;
        Prototype p3 = PrototypeManager.getPrototype("p1").clone();
        System.out.println("p3��ʼ��¡p1,δ��ֵ �� " + p3);
        p3.setName("����");
        System.out.println("p3��ֵ�� �� " + p3);

        Prototype p2 = new ConcretePrototype2();
        PrototypeManager.setPrototype("p1", p2);
        Prototype p4 = PrototypeManager.getPrototype("p1").clone();
        System.out.println("p4��ʼ��¡p1,δ��ֵ �� " + p4);
        p4.setName("����");
        System.out.println("p4��ֵ�� �� " + p4);
        PrototypeManager.removePrototype("p1");
        Prototype p5 = PrototypeManager.getPrototype("p1").clone();
        System.out.println("p4��ʼ��¡p1,δ��ֵ �� " + p5);
        p5.setName("����");
        System.out.println("p5��ֵ�� �� " + p5);
    }
}

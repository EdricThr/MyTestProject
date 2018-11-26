package com.THR.DesignPatterns.原型模式;

public class Client_YuanXing {

    public static void main(String args[]) throws Exception {
        Prototype p1 = new ContretePrototype1();
        PrototypeManager.setPrototype("p1", p1);;
        Prototype p3 = PrototypeManager.getPrototype("p1").clone();
        System.out.println("p3初始克隆p1,未赋值 ： " + p3);
        p3.setName("张三");
        System.out.println("p3赋值后 ： " + p3);

        Prototype p2 = new ConcretePrototype2();
        PrototypeManager.setPrototype("p1", p2);
        Prototype p4 = PrototypeManager.getPrototype("p1").clone();
        System.out.println("p4初始克隆p1,未赋值 ： " + p4);
        p4.setName("李四");
        System.out.println("p4赋值后 ： " + p4);
        PrototypeManager.removePrototype("p1");
        Prototype p5 = PrototypeManager.getPrototype("p1").clone();
        System.out.println("p4初始克隆p1,未赋值 ： " + p5);
        p5.setName("王五");
        System.out.println("p5赋值后 ： " + p5);
    }
}

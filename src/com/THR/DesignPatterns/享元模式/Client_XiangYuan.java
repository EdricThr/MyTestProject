package com.THR.DesignPatterns.ÏíÔªÄ£Ê½;

public class Client_XiangYuan {

    public static void main(String args[]){

        FlyweightFactory flyweightFactory = new FlyweightFactory();

        Flyweight flyweight1 = flyweightFactory.factory("aaa");
        flyweight1.operation("flyweight1");
        Flyweight flyweight2 = flyweightFactory.factory("bbb");
        flyweight2.operation("flyweight2");
        Flyweight flyweight3 = flyweightFactory.factory("aaa");
        flyweight3.operation("flyweight3");

        System.out.printf("flyweight1 == flyweight3: %b%n", (flyweight1 == flyweight3));
    }
}

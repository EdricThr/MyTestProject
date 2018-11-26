package com.THR.DesignPatterns.代理模式.动态代理2;

public class Client_DD2 {

    public static void main(String args[]){
        //plane需要实现了接口
        Flayable plane = new Plane();
        System.out.println(plane.getClass());

        Flayable proxy = (Flayable) new ProxyFly(plane).getProxyInstance();

        System.out.println(proxy.getClass());

        proxy.fly();

    }
}

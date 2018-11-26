package com.THR.DesignPatterns.代理模式.智能引用代理.CgLib;

public class Client {
    public static void main(String args[]){
        CglibProxy proxy = new CglibProxy();
        Train train = (Train) proxy.getProxy(Train.class);
        train.move();
    }
}

package com.THR.DesignPatterns.代理模式.智能引用代理.静态代理;

public class Client_JingTaiDaiLi1 {
    public static void main(String args[]){

        Car car = new Car();
        CarLogProxy car1 = new CarLogProxy(car);
        CarTimeProxy car2 = new CarTimeProxy(car1);
        car2.move();
    }
}

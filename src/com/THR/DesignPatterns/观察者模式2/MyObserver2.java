package com.THR.DesignPatterns.观察者模式2;

public class MyObserver2 implements MyObserver {


    @Override
    public void upadate(float temp) {
        System.out.println("MyObserver2气温：" + temp);
    }
}

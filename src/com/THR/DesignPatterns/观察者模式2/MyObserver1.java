package com.THR.DesignPatterns.观察者模式2;

public class MyObserver1 implements MyObserver {

    @Override
    public void upadate(float temp) {
        System.out.println("MyObserver1气温：" + temp);
    }
}

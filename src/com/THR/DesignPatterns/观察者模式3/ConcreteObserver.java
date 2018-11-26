package com.THR.DesignPatterns.观察者模式3;

public class ConcreteObserver implements Observer {
    @Override
    public void update(String data) {
        System.out.println("更新信息：" + data);
    }
}

package com.THR.DesignPatterns.观察者模式3;

public class Client_Observer3 {

    public static void main(String args[]){
        ConcreteObserver concreteObserver = new ConcreteObserver();
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.attach(concreteObserver);
        concreteSubject.change("通知信息1");
    }
}

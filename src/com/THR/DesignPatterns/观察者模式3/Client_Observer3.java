package com.THR.DesignPatterns.�۲���ģʽ3;

public class Client_Observer3 {

    public static void main(String args[]){
        ConcreteObserver concreteObserver = new ConcreteObserver();
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.attach(concreteObserver);
        concreteSubject.change("֪ͨ��Ϣ1");
    }
}

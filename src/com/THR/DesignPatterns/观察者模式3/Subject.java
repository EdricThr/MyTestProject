package com.THR.DesignPatterns.观察者模式3;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList();

    public void attach(Observer observer) {
        observers.add(observer);
    }
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObserver(String data) {
        for (Observer observer : observers) {
            observer.update(data);
        }
    }
}
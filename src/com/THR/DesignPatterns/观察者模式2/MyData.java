package com.THR.DesignPatterns.观察者模式2;

import java.util.ArrayList;
import java.util.List;

public class MyData {

    private float temp;
    private List<MyObserver> myObservers = new ArrayList<>();

    public void registerObserver(MyObserver observer) {
        myObservers.add(observer);
    }

    public void notifyObservers() {
        for (MyObserver observer : myObservers) {
            observer.upadate(temp);
        }
    }

    public void updateTemp(float temp) {
        this.temp = temp;
        notifyObservers();
    }
}

package com.THR.DesignPatterns.�۲���ģʽ;

public interface Subject {

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

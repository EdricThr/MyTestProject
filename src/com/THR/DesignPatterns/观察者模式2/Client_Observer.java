package com.THR.DesignPatterns.�۲���ģʽ2;

public class Client_Observer {

    public static void main(String args[]){
        MyData myData = new MyData();
        myData.registerObserver(new MyObserver1());
        myData.registerObserver(new MyObserver2());
        myData.updateTemp(30);
        myData.updateTemp(50);
    }
}

package com.THR.DesignPatterns.外观模式;

public class Client_WaiGuan {
    public static void main(String args[]){
        Facade facade = new Facade();

        //客户端只需要知道门面对象的方法即可
        facade.doOperationA();

        System.out.println("---------------");
        facade.doOperationB();
    }
}

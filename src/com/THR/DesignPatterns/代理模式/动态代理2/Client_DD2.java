package com.THR.DesignPatterns.����ģʽ.��̬����2;

public class Client_DD2 {

    public static void main(String args[]){
        //plane��Ҫʵ���˽ӿ�
        Flayable plane = new Plane();
        System.out.println(plane.getClass());

        Flayable proxy = (Flayable) new ProxyFly(plane).getProxyInstance();

        System.out.println(proxy.getClass());

        proxy.fly();

    }
}

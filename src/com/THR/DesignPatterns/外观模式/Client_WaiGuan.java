package com.THR.DesignPatterns.���ģʽ;

public class Client_WaiGuan {
    public static void main(String args[]){
        Facade facade = new Facade();

        //�ͻ���ֻ��Ҫ֪���������ķ�������
        facade.doOperationA();

        System.out.println("---------------");
        facade.doOperationB();
    }
}

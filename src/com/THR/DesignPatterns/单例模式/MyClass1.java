package com.THR.DesignPatterns.����ģʽ;

/**
 * ʹ������ģʽ1
 * ȱ�㣺
 *  ��֧�ֲ���
 */
public class MyClass1 {
    private static MyClass1 myClass = null;
    private MyClass1(){}
    public static MyClass1 getInstance() {
        if (null == myClass) {
            myClass = new MyClass1();
        }
        return myClass;
    }
}

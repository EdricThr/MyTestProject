package com.THR.DesignPatterns.����ģʽ;

/**
 * ʹ������ģʽ2
 * ���1�Ľ�:���������synchronized
 */
public class MyClass2 {
    private static MyClass2 myClass = null;
    private MyClass2(){}
    public static synchronized MyClass2 getInstance() {
        if (null == myClass) {
            myClass = new MyClass2();
        }
        return myClass;
    }
}

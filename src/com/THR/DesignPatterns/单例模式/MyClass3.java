package com.THR.DesignPatterns.����ģʽ;

/**
 * ʹ�ö���ģʽ
 * ���1�Ľ�:��������ֱ�����ɣ�������ͬ������
 */
public class MyClass3 {
    private static MyClass3 myClass = new MyClass3();
    private MyClass3(){}
    public static MyClass3 getInstance() {
        return myClass;
    }
}

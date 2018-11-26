package com.THR.DesignPatterns.单例模式;

/**
 * 使用懒汉模式1
 * 缺点：
 *  不支持并发
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

package com.THR.DesignPatterns.单例模式;

/**
 * 使用懒汉模式2
 * 相对1改进:方法添加了synchronized
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

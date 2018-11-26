package com.THR.DesignPatterns.单例模式;

/**
 * 使用饿汉模式
 * 相对1改进:单例对象直接生成，避免了同步问题
 */
public class MyClass3 {
    private static MyClass3 myClass = new MyClass3();
    private MyClass3(){}
    public static MyClass3 getInstance() {
        return myClass;
    }
}

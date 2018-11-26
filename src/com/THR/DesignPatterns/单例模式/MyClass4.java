package com.THR.DesignPatterns.单例模式;

/**
 * 双重检查加锁方式
 */
public class MyClass4 {
    private static MyClass4 myClass = null;
    private MyClass4(){}
    public static MyClass4 getInstance() {
        //先进行一次判空
        if (null == myClass) {
            synchronized (MyClass4.class) {
                //再进行一次判空，这样能够保证只有一次初始化
                if (null == myClass) {
                    myClass = new MyClass4();
                }
            }
        }
        return myClass;
    }
}

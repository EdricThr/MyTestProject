package com.THR.DesignPatterns.����ģʽ;

/**
 * ˫�ؼ�������ʽ
 */
public class MyClass4 {
    private static MyClass4 myClass = null;
    private MyClass4(){}
    public static MyClass4 getInstance() {
        //�Ƚ���һ���п�
        if (null == myClass) {
            synchronized (MyClass4.class) {
                //�ٽ���һ���пգ������ܹ���ֻ֤��һ�γ�ʼ��
                if (null == myClass) {
                    myClass = new MyClass4();
                }
            }
        }
        return myClass;
    }
}

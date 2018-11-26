package com.THR.DesignPatterns.����ģʽ.�������ô���.��̬����.Jdk��̬����;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimerHandler implements InvocationHandler {

    /**
     * Ҫ����Ķ���
     */
    private Object target;

    public TimerHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy ������Ķ���
     * @param method ������Ķ���ķ���
     * @param args �����Ĳ���
     * @return ����ֵ��������Ķ���ķ����ķ���ֵ
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //����ʹ��ͨ���������������ơ�����ǩ�������������ȣ�����ĳЩ����Ҫ�ķ�������
        //if (method.getName().equals("aabbcc")) {
        //    System.out.println("ִ�ж������");
        //}

        System.out.println("��ʼ��¼������ʻ��ʱ��");
        long startTime = System.currentTimeMillis();
        method.invoke(target);
        long endTime = System.currentTimeMillis();
        long moveTime = endTime - startTime;
        System.out.println("������ʻ��ʱ�䣺" + moveTime);
        System.out.println("������¼������ʻ��ʱ��");
        return null;
    }
}

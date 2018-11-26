package com.THR.DesignPatterns.����ģʽ.�������ô���.CgLib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){

        //���ô����������
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return enhancer.create();
    }


    /**
     * ����Ŀ���෽���ĵ���
     * @param o Ŀ�����ʵ��
     * @param method Ŀ�귽���ķ������
     * @param objects �����Ĳ���
     * @param methodProxy �������ʵ��
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("��ʼ��¼��־....");
        //��������ø���ķ���
        methodProxy.invokeSuper(o, objects);
        System.out.println("��ʼ��¼��־....");

        return null;
    }
}

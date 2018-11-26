package com.THR.DesignPatterns.ģ��ģʽ;

public abstract class AbstractMethod {

    /**
     * ����ģ�巽��
     * �����߼�/������Ϊ
     * ��������û�������Ŀɱ䲿�֣���������ȴ�����Ըı�ģ�巽��������Ķ����߼�
     */
    public final void templateMethod() {
        //ģ����û�������
        abstractMethod();
        hookMethod();
        concreteMethod();
    }

    /**
     * ������������(������ʵ�����Լ����߼�)
     */
    protected abstract void abstractMethod();

    /**
     * �����������շ���������Ҳ����д
     */
    protected void hookMethod() {

    }

    /**
     * ��������(�Ѿ�ʵ��)
     */
    private final void concreteMethod() {
        //�����Լ���ҵ���߼�
    }
}

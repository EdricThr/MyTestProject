package com.THR.ThinkingInJava.������Ϣ.Class����;

/**
 * ʹ������.class ���� Class��������� p319
 *
 */
public class ClassInitialization {

    public static void main(String args[]) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("�Ѵ���Initable.class");
        //ֱ��ʹ��static final �����ڳ���������ʵ��������
        System.out.println(Initable.staticFinal);
        System.out.println("++++");
        //��Ȼ�������ͱ���Ҳ����Ϊ�� static final ,����ʹ��ʱҲ��ʵ�������󣨷Ǳ�����������
        System.out.println(Initable.candy);
        System.out.println("-----------------");
        //��final��������ʵ��������
        System.out.println(Initable2.staticFinal);
        System.out.println("++++");
        System.out.println(Initable2.candy);
        System.out.println("-----------------");
        //���Class�����ʱ��س�ʼ������
        Class initable3 = Class.forName("com.ThinkingInJava.������Ϣ.Class����.Initable3");
        System.out.println("�Ѵ���Initable3.class");
        System.out.println(Initable3.staticFinal);
        System.out.println("++++");
        System.out.println(Initable3.candy);
    }

}

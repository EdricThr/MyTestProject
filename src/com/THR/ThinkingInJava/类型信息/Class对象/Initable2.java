package com.THR.ThinkingInJava.������Ϣ.Class����;

public class Initable2 {
        //��final��������ʵ��������
        static int staticFinal = 12;
        static Candy candy = new Candy();
        static {
            System.out.println("ʵ����Initable");
        }
}
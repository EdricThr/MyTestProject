package com.THR.ThinkingInJava.������Ϣ.Class����;

public class Initable {
        //ֱ��ʹ��static final �����ڳ���������ʵ��������
        static final int staticFinal = 11;
        //��Ȼ�������ͱ���Ҳ����Ϊ�� static final ,����ʹ��ʱҲ��ʵ�������󣨷Ǳ�����������
        static final Candy candy = new Candy();
        static {
            System.out.println("ʵ����Initable");
        }
}
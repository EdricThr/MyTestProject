package com.THR.ThinkingInJava.������Ϣ.Class����;

public class Candy {
    static {
        System.out.println("---Candy static��----");
    }

    public Candy(int  i) {

    }
    //���û��Ĭ����ʽ���޲ι�������ʹ��class����.newInstance()������ InstantiationException
    public Candy() {
        System.out.println("�޲ι���candy");
    }
    @Override
    public String toString() {
        return "Candy.toString...";
    }
}

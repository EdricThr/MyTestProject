package com.THR.ThinkingInJava.����Ȩ��;

public class Student extends People {
    //�ɼ�����ͬ�������У����Է��ʵ��� private ������������δ����εı���
    public void sout() {
        System.out.println(super.name);
        System.out.println(super.address);
        System.out.println(super.habit);
    }
}
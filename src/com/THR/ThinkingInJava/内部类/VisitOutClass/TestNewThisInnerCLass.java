package com.THR.ThinkingInJava.�ڲ���.VisitOutClass;

public class TestNewThisInnerCLass {

    public static void main(String args[]){
        Sequence sequence = new Sequence(10);
        //�����ڲ��������Ҫ���ⲿ����������
        Sequence.SquenceSelector squenceSelector = sequence.new SquenceSelector();
        System.out.println(squenceSelector.end());
        //�����ڲ���̬����󣬲���Ҫ���ⲿ����������
        Sequence.A aa = new Sequence.A();
    }
}

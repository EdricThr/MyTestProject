package com.THR.ThinkingInJava.����Ȩ��2;


import com.THR.ThinkingInJava.����Ȩ��.People;

public class OtherPackageStudent extends People {
    //�ɼ����������������У�ͬ�������Է��ʵ��� private ���δ����εı���
    //�ܷ���protected���εı���
    //���ǲ��ܷ��ʵ�default����
    //����˵�������������ֻ࣬�ܷ��ʵ�public��protected���α���
    public void sout() {
        System.out.println(super.name);
        //System.out.println(super.address);//�޷���Ȩ��
        System.out.println(super.habit);
    }
}
package com.THR.ThinkingInJava.����Ȩ��2;


import com.THR.ThinkingInJava.����Ȩ��.People;

public class TestOtherPackageVisit {

    public static void main(String args[]){
        People people = new People();
        //ͬ�����ܷ���private���εı���
        //���ܷ��ʵ�protected����
        //���ܷ��ʵ�default����
        //����˵�������������ֻ࣬�ܷ��ʵ�public����
        System.out.println(people.name);
        //System.out.println(people.address);
        //System.out.println(people.habit);
    }
}

package com.THR.ThinkingInJava.����Ȩ��;

public class TestSamePackageVisit {

    public static void main(String args[]){
        People people = new People();
        //���Է��ʳ�private���������������
        // �ɼ���ͬ���£�����ķ���Ȩ����ͬ��
        System.out.println(people.name);
        System.out.println(people.address);
        System.out.println(people.habit);
    }

    class cake{

    }
}

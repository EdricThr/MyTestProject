package com.THR.�̳�;

/**
 * ���Է�������ʱ�����ֱ��Ǹ���������ǵĵ���
 */
public class doTestMethodWithParam {

    public static void main(String args[]){

        People people = new Student();
        People student = new Student();
        method(people);
        method(student);
    }

    public static void method(People people) {
        System.out.println("People");
    }
    public static void method(Student student) {
        System.out.println("Student");
    }
}

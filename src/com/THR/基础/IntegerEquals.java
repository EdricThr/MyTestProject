package com.THR.»ù´¡;

public class IntegerEquals {

    public static void main(String args[]){

        Student stu1 = new Student();
        stu1.age = 10;
        Student stu2 = new Student();
        stu2.age = 10;

        System.out.println(stu1.age.equals(stu2.age));

        Integer a = new Integer(1);
        Integer b = new Integer(1);

        System.out.println(a.equals(b));
    }

    static class Student {
        Integer age;
    }
}

package com.THR.继承;

/**
 * 测试方法重载时参数分别是父类和子类是的调用
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

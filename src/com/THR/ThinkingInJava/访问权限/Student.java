package com.THR.ThinkingInJava.访问权限;

public class Student extends People {
    //可见，在同包子类中，可以访问到除 private 以外的其他修饰词修饰的变量
    public void sout() {
        System.out.println(super.name);
        System.out.println(super.address);
        System.out.println(super.habit);
    }
}
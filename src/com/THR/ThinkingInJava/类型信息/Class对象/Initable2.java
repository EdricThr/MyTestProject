package com.THR.ThinkingInJava.类型信息.Class对象;

public class Initable2 {
        //非final变量，会实例化对象
        static int staticFinal = 12;
        static Candy candy = new Candy();
        static {
            System.out.println("实例化Initable");
        }
}
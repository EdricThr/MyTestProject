package com.THR.ThinkingInJava.类型信息.Class对象;

public class Initable3 {
        static final int staticFinal = 13;
        static Candy candy = new Candy();
        static {
            System.out.println("实例化Initable");
        }
}
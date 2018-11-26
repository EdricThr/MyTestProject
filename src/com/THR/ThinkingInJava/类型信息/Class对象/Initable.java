package com.THR.ThinkingInJava.类型信息.Class对象;

public class Initable {
        //直接使用static final 编译期常量，不会实例化对象
        static final int staticFinal = 11;
        //虽然引用类型变量也声明为了 static final ,但是使用时也会实例化对象（非编译器常量）
        static final Candy candy = new Candy();
        static {
            System.out.println("实例化Initable");
        }
}
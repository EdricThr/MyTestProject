package com.THR.ThinkingInJava.类型信息.Class对象;

public class Candy {
    static {
        System.out.println("---Candy static域----");
    }

    public Candy(int  i) {

    }
    //如果没有默认形式的无参构造器，使用class引用.newInstance()将报错 InstantiationException
    public Candy() {
        System.out.println("无参构造candy");
    }
    @Override
    public String toString() {
        return "Candy.toString...";
    }
}

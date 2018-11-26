package com.THR.ThinkingInJava.内部类.匿名内部类;

/**
 * 匿名类基本使用2，内部类基类含有参数
 */
public class DefineNoNameClass3 {

    public Wrapping wrappings(int i) {
        return new Wrapping(i) {
            @Override
            public int value() {
                return super.value() * 2;
            }
        };
    }
    public Wrapping wrappings() {
        return new Wrapping() {
            @Override
            public int value() {
                return super.value();
            }
        };
    }

    public static void main(String args[]){
        DefineNoNameClass3 defineNoNameClass = new DefineNoNameClass3();
        Wrapping wrapping = defineNoNameClass.wrappings(10);
        System.out.println(wrapping.value());
        Wrapping wrapping2 = defineNoNameClass.wrappings();
        System.out.println(wrapping2.value());
    }
}

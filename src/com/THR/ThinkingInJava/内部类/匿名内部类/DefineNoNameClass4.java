package com.THR.ThinkingInJava.内部类.匿名内部类;

/**
 * 匿名类基本使用4,匿名内部类使用外部定义的对象,该参数引用必须是final的（构造函数参数传入除外）
 */
public class DefineNoNameClass4 {

    public Wrapping wrappings(int i) {
        int ii = i;
        final int iii = 5;
        return new Wrapping(ii) {
            int iiii = iii;
            //int iiiii= i;
            @Override
            public int value() {
                return super.value() * 2;
            }
        };
    }

    public static void main(String args[]){
        DefineNoNameClass4 defineNoNameClass = new DefineNoNameClass4();
        Wrapping wrapping = defineNoNameClass.wrappings(10);
        System.out.println(wrapping.value());
    }
}

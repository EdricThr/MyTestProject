package com.THR.ThinkingInJava.�ڲ���.�����ڲ���;

/**
 * ���������ʹ��2���ڲ�����ຬ�в���
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

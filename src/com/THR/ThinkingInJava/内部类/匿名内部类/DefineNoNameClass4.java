package com.THR.ThinkingInJava.�ڲ���.�����ڲ���;

/**
 * ���������ʹ��4,�����ڲ���ʹ���ⲿ����Ķ���,�ò������ñ�����final�ģ����캯������������⣩
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

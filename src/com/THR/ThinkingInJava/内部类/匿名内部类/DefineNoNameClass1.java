package com.THR.ThinkingInJava.�ڲ���.�����ڲ���;

/**
 * ������Ļ���ʹ��
 */
public class DefineNoNameClass1 {

    public Contents contends() {
        return new Contents() {
            @Override
            public int value() {
                return 1;
            }
        };
    }

    public static void main(String args[]){
        DefineNoNameClass1 defineNoNameClass = new DefineNoNameClass1();
        Contents c = defineNoNameClass.contends();
    }
}

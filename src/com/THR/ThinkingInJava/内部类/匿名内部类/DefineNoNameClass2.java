package com.THR.ThinkingInJava.�ڲ���.�����ڲ���;

/**
 * δʹ�������ڲ��࣬����ʹ�÷����������������ķ�ʽʹ���ڲ���
 */
public class DefineNoNameClass2 {

   public class MyContends implements Contents{
       @Override
       public int value() {
           return 1;
       }
   }
   public Contents contends(){
       return new MyContends();
   }

    public static void main(String args[]){
        DefineNoNameClass2 defineNoNameClass = new DefineNoNameClass2();
        Contents c = defineNoNameClass.contends();
    }
}

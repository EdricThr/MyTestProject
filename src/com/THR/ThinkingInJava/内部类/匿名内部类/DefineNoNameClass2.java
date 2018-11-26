package com.THR.ThinkingInJava.内部类.匿名内部类;

/**
 * 未使用匿名内部类，还是使用方法返回匿名类对象的方式使用内部类
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

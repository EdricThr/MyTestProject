package com.THR.ThinkingInJava.内部类.VisitOutClass;

public class TestNewThisInnerCLass {

    public static void main(String args[]){
        Sequence sequence = new Sequence(10);
        //创建内部类对象，需要对外部类对象的引用
        Sequence.SquenceSelector squenceSelector = sequence.new SquenceSelector();
        System.out.println(squenceSelector.end());
        //创建内部静态类对象，不需要对外部类对象的引用
        Sequence.A aa = new Sequence.A();
    }
}

package com.THR.ThinkingInJava.访问权限;

public class TestSamePackageVisit {

    public static void main(String args[]){
        People people = new People();
        //可以访问除private修饰外的其他变量
        // 可见，同包下，各类的访问权限相同，
        System.out.println(people.name);
        System.out.println(people.address);
        System.out.println(people.habit);
    }

    class cake{

    }
}

package com.THR.ThinkingInJava.访问权限2;


import com.THR.ThinkingInJava.访问权限.People;

public class TestOtherPackageVisit {

    public static void main(String args[]){
        People people = new People();
        //同样不能访问private修饰的变量
        //不能访问到protected变量
        //不能访问到default变量
        //或者说，其他包非子类，只能访问到public变量
        System.out.println(people.name);
        //System.out.println(people.address);
        //System.out.println(people.habit);
    }
}

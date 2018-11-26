package com.THR.ThinkingInJava.访问权限2;


import com.THR.ThinkingInJava.访问权限.People;

public class OtherPackageStudent extends People {
    //可见，在其它包子类中，同样不可以访问到除 private 修饰词修饰的变量
    //能访问protected修饰的变量
    //但是不能访问到default变量
    //或者说，其他包下子类，只能访问到public、protected修饰变量
    public void sout() {
        System.out.println(super.name);
        //System.out.println(super.address);//无访问权限
        System.out.println(super.habit);
    }
}
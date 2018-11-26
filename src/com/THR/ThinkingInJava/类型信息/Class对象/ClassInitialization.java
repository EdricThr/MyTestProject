package com.THR.ThinkingInJava.类型信息.Class对象;

/**
 * 使用类名.class 产生 Class对象的引用 p319
 *
 */
public class ClassInitialization {

    public static void main(String args[]) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("已创建Initable.class");
        //直接使用static final 编译期常量，不会实例化对象
        System.out.println(Initable.staticFinal);
        System.out.println("++++");
        //虽然引用类型变量也声明为了 static final ,但是使用时也会实例化对象（非编译器常量）
        System.out.println(Initable.candy);
        System.out.println("-----------------");
        //非final变量，会实例化对象
        System.out.println(Initable2.staticFinal);
        System.out.println("++++");
        System.out.println(Initable2.candy);
        System.out.println("-----------------");
        //获得Class对象的时候回初始化对象
        Class initable3 = Class.forName("com.ThinkingInJava.类型信息.Class对象.Initable3");
        System.out.println("已创建Initable3.class");
        System.out.println(Initable3.staticFinal);
        System.out.println("++++");
        System.out.println(Initable3.candy);
    }

}

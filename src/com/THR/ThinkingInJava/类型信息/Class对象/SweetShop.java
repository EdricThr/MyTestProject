package com.THR.ThinkingInJava.类型信息.Class对象;

public class SweetShop {

    /**
     * Class.forName("类全限定名");返回Class对象的引用
     * @param args
     */
    public static void main(String args[]){
        Class c = null;
        try {
            c = Class.forName("com.ThinkingInJava.类型信息.Class对象.Candy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        printClassInfo(c);
        newInstanceClass(c);
        //try {
        //    Class.forName("Candy2");
        //} catch (ClassNotFoundException e) {
        //    e.printStackTrace();
        //}
    }

    /**
     * 输出Class相关信息
     *   c.getName() 返回类的全限定名
         c.getCanonicalName() 返回类的全限定名
         c.getSimpleName() 返回类名
         c.isInterface() 返回是否接口（boolean）
         c.getSuperclass() 返回基类的Class引用
     * @param c
     */
    public static void printClassInfo(Class c) {
        System.out.println("getName: " + c.getName());
        System.out.println("getCanonicalName: " + c.getCanonicalName());
        System.out.println("getSimpleName: " + c.getSimpleName());
        System.out.println("isInterface: " + c.isInterface());
        System.out.println("getSuperclass: " + c.getSuperclass());
    }

    /**
     * c.newInstance(); 虚拟构造器的一种，得到Object引用
     * 使用时，必须保证该类有默认格式的构造器
     * 如果没有默认形式的无参构造器，使用class引用.newInstance()将报错 InstantiationException
     * @param c
     */
    public static void newInstanceClass(Class c) {
        try {
            Object obj = c.newInstance();
            System.out.println(obj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

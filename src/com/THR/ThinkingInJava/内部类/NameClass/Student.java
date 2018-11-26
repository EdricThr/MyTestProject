package com.THR.ThinkingInJava.内部类.NameClass;

/**
 * //在D盘下创建文件 nameCalss.java,代码如下:
 * 可见，类中不包含public class,
 *      而且任何一个class的命名都和java文件名称不同；
 *      且，具有多个main方法
 *  在使用时，需要先编译.java文件，命令为：javac nameClass.java
 *          运行时，使用命令 java Student 或 java People
 *  得出：在不含有public class的类中，可以包含多个编译单元。
 *       编译时使用类名，运行时使用class名称
 */
class Student {
    public static void main(String args[]){
        System.out.println("student...");
    }
}
class People {

    public static void main(String args[]){
        System.out.println("people...");
    }
}

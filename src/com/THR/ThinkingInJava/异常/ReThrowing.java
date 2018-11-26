package com.THR.ThinkingInJava.异常;

/**
 * 测试重新抛出异常 p462
 */
public class ReThrowing {
    public static void f() throws Exception {
        System.out.println("进入f()方法内部。。");
        throw new Exception("f()方法抛出异常");
    }

    public static void g() throws Exception {
        try {
            f();
        }catch (Exception e) {
            System.out.println("进入g()方法内部处理异常");
            e.printStackTrace(System.out);
            throw e;
        }
    }
    public static void h() throws Exception {
        try {
            f();
        }catch (Exception e) {
            System.out.println("进入h()方法内部处理异常");
            e.printStackTrace(System.out);
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String args[]){

        try {
            g();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        System.out.println("-------------------");

        try {
            h();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

}

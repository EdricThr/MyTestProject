package com.THR.ThinkingInJava.�쳣;

/**
 * ���������׳��쳣 p462
 */
public class ReThrowing {
    public static void f() throws Exception {
        System.out.println("����f()�����ڲ�����");
        throw new Exception("f()�����׳��쳣");
    }

    public static void g() throws Exception {
        try {
            f();
        }catch (Exception e) {
            System.out.println("����g()�����ڲ������쳣");
            e.printStackTrace(System.out);
            throw e;
        }
    }
    public static void h() throws Exception {
        try {
            f();
        }catch (Exception e) {
            System.out.println("����h()�����ڲ������쳣");
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

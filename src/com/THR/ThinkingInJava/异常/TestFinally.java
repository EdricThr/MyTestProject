package com.THR.ThinkingInJava.�쳣;

public class TestFinally {


    public static void main(String args[]){
        testFinallyDo();
    }

    /**
     * ��֤ finally ��ʱ�ᱻִ��
     * �ɼ��������Ƿ����쳣��finally�ܻᱻִ��
     */
    public static void testFinallyDo() {

        try {
            System.out.println("ִ�����");
            throw new Exception("�׳��쳣");
        }catch (Exception e) {
            System.out.println("����catch");
            e.printStackTrace(System.out);
            System.out.println("����catch");
        }finally {
            System.out.println("Finally");
        }
        System.out.println("--------------------");
        try {
            System.out.println("ִ�����");
        }catch (Exception e) {
            System.out.println("����catch");
            e.printStackTrace(System.out);
            System.out.println("����catch");
        }finally {
            System.out.println("Finally");
        }
    }
}

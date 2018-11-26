package com.THR.ThinkingInJava.������Ϣ.Class����;

public class SweetShop {

    /**
     * Class.forName("��ȫ�޶���");����Class���������
     * @param args
     */
    public static void main(String args[]){
        Class c = null;
        try {
            c = Class.forName("com.ThinkingInJava.������Ϣ.Class����.Candy");
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
     * ���Class�����Ϣ
     *   c.getName() �������ȫ�޶���
         c.getCanonicalName() �������ȫ�޶���
         c.getSimpleName() ��������
         c.isInterface() �����Ƿ�ӿڣ�boolean��
         c.getSuperclass() ���ػ����Class����
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
     * c.newInstance(); ���⹹������һ�֣��õ�Object����
     * ʹ��ʱ�����뱣֤������Ĭ�ϸ�ʽ�Ĺ�����
     * ���û��Ĭ����ʽ���޲ι�������ʹ��class����.newInstance()������ InstantiationException
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

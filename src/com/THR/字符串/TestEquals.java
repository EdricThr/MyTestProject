package com.THR.×Ö·û´®;

public class TestEquals {

    public static void main(String args[]){

        Student stu = new Student();
        boolean b1 = stu.UserName.equals("stu");
        System.out.println(b1);
    }
    static class Student{
        public String UserName;
    }
}

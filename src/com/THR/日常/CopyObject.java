package com.THR.ÈÕ³£;

/**
 * @author Thr
 */
public class CopyObject {

    public static void main(String args[]){
        Student student = new Student();
        student.username = "THR";
        Student student2 = student;
        student2.username = "TTT";
        System.out.println(student.username);
    }

    static class Student{
        public String username;
    }
}

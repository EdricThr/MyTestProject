package com.THR.ผฬณะ;

public class TestInstance {

    public static void main(String args[]){
        People people = new People();
        Student student = new Student();
        Worker worker = new Worker();

        System.out.println(People.class.isInstance(student));
        System.out.println(Student.class.isInstance(student));
        people = new Student();
        System.out.println(People.class.isInstance(people));
        System.out.println(Student.class.isInstance(people));


        System.out.println("-----------------");
        System.out.println(student instanceof Student);



    }
    static class People{

    }
    static class Worker extends People{

    }
    static class Student extends People{

    }
}

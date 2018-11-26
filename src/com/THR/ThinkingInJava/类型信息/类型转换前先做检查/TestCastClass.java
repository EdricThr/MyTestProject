package com.THR.ThinkingInJava.类型信息.类型转换前先做检查;

public class TestCastClass {
    static class Stu {

    }
    static class Peo {

    }

    public static void main(String args[]){
        Object stu = new Stu();
        Peo peo = (Peo) stu;
    }

}

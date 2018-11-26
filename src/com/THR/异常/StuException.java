package com.THR.“Ï≥£;

public class StuException {

    public static void main(String args[]){
        testReturnInTry();
    }

    public static void testReturnInTry(){
        try {
            System.out.println("1.try....");
            return;
        }finally {
            System.out.println("2.finally....");
        }
    }
}

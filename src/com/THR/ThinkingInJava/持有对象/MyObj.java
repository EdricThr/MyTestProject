package com.THR.ThinkingInJava.持有对象;

public class MyObj{
        int i = 0;
        int j = 0;

        public MyObj(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object obj) {
            System.out.println("调用equals方法，this:" + this + "; obj: " + obj);
            return i == ((MyObj)obj).i;
        }

        @Override
        public int hashCode() {
            System.out.println("调用hashCode方法，this:" + this);
            return j;
        }

        @Override
        public String toString() {
            return "MyObj{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
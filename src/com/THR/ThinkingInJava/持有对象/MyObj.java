package com.THR.ThinkingInJava.���ж���;

public class MyObj{
        int i = 0;
        int j = 0;

        public MyObj(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object obj) {
            System.out.println("����equals������this:" + this + "; obj: " + obj);
            return i == ((MyObj)obj).i;
        }

        @Override
        public int hashCode() {
            System.out.println("����hashCode������this:" + this);
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
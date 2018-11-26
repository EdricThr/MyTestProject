package com.THR.ThinkingInJava.Êý×é.ÅÅÐò;

public class CompType implements Comparable<CompType>{

    int i;
    int j;
    private static int count = 1;
    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        String result = "CompType{" +
                "i=" + i +
                ", j=" + j +
                '}';
        if (count++ % 3 == 0) {
            result += "\n";
        }
        return result;
    }


    @Override
    public int compareTo(CompType o) {
        return i - o.i;
    }
}

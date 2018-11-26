package com.THR.ThinkingInJava.·ºÐÍ.Ôª×é;

public class ThreeTyple<A, B, C> extends TwoTuple<A, B> {

    public  final C third;

    public ThreeTyple(A a, B b, C c) {
        super(a, b);
        this.third = c;
    }

    @Override
    public String toString() {
        return "ThreeTyple{" +
                "third=" + third +
                ", first=" + first +
                ", second=" + second +
                '}';
    }
}

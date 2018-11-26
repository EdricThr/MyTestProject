package com.THR.ThinkingInJava.泛型.元组;

public class TwoTuple<A, B> {

    //虽然设置为public变量，但是由于是final变量，外部不能改变，
    // 如果想要改变first或second的值，需要创建新的对象
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        this.first = a;
        this.second = b;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}

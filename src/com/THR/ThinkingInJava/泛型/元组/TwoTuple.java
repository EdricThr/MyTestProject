package com.THR.ThinkingInJava.����.Ԫ��;

public class TwoTuple<A, B> {

    //��Ȼ����Ϊpublic����������������final�������ⲿ���ܸı䣬
    // �����Ҫ�ı�first��second��ֵ����Ҫ�����µĶ���
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

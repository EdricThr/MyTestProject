package com.THR.DesignPatterns.�Ž�ģʽ;

/**
 * ���Լ������峬�࣬���ۺ���һ�����࣬�ﵽ���ҵ���Ч��
 */
public abstract class HighAbstration {
    private Abstraction abs;

    public HighAbstration(Abstraction abs) {
        this.abs = abs;
    }

    public void highOperation() {
        abs.operation();
    }
}

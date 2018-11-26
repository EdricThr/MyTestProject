package com.THR.DesignPatterns.StatePatternOne;

import java.util.Random;

public class Client_ZhuangTai1 {

    public static void main(String args[]){
        State state;
        Context context = new Context();
        //ʹ�������ģ��״̬�ĸı�
        if (new Random().nextBoolean()) {
            state = new ConcreteStateA();
        }else {
            state = new ConcreteStateB();
        }
        context.setState(state);
        context.request("test");
    }
}

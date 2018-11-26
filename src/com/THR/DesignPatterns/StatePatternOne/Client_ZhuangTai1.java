package com.THR.DesignPatterns.StatePatternOne;

import java.util.Random;

public class Client_ZhuangTai1 {

    public static void main(String args[]){
        State state;
        Context context = new Context();
        //使用随机数模拟状态的改变
        if (new Random().nextBoolean()) {
            state = new ConcreteStateA();
        }else {
            state = new ConcreteStateB();
        }
        context.setState(state);
        context.request("test");
    }
}

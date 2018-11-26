package com.THR.DesignPatterns.不知名模式1;

public class ConfirmChainFactory {
    public static ConfirmChain newConfirmChain() {
        return new MyConfirmChain();
    }
}

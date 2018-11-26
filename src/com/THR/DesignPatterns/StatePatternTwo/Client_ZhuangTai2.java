package com.THR.DesignPatterns.StatePatternTwo;

public class Client_ZhuangTai2 {

    public static void main(String args[]){
        VoteManager vm = new VoteManager();
        for (int i = 0; i < 10; i++) {
            vm.vote("u1", "A");
        }
    }
}
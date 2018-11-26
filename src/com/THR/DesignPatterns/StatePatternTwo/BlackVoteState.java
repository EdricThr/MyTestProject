package com.THR.DesignPatterns.StatePatternTwo;

public class BlackVoteState implements VoteState {
    @Override
    public void voite(String user, String voteItem, VoteManager voteManager) {
        System.out.println("进入黑名单，将禁止登陆和使用本系统");
    }
}

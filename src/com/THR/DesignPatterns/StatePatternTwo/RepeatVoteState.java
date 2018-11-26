package com.THR.DesignPatterns.StatePatternTwo;

public class RepeatVoteState implements VoteState {
    @Override
    public void voite(String user, String voteItem, VoteManager voteManager) {
        System.out.println("请不要重复投票");
    }
}

package com.THR.DesignPatterns.StatePatternTwo;

public class BlackVoteState implements VoteState {
    @Override
    public void voite(String user, String voteItem, VoteManager voteManager) {
        System.out.println("���������������ֹ��½��ʹ�ñ�ϵͳ");
    }
}

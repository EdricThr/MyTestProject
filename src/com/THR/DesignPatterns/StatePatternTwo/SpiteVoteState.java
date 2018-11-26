package com.THR.DesignPatterns.StatePatternTwo;

public class SpiteVoteState implements VoteState {
    @Override
    public void voite(String user, String voteItem, VoteManager voteManager) {
        String spiteUser = voteManager.getMapVote().get(user);
        if (null != spiteUser) {
            voteManager.getMapVote().remove(spiteUser);
            System.out.println("���ж���ˢƱ��Ϊ��ȡ��ͶƱ�ʸ�");
        }
    }
}

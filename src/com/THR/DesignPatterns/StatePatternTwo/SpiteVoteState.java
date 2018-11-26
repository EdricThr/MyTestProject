package com.THR.DesignPatterns.StatePatternTwo;

public class SpiteVoteState implements VoteState {
    @Override
    public void voite(String user, String voteItem, VoteManager voteManager) {
        String spiteUser = voteManager.getMapVote().get(user);
        if (null != spiteUser) {
            voteManager.getMapVote().remove(spiteUser);
            System.out.println("你有恶意刷票行为，取消投票资格");
        }
    }
}

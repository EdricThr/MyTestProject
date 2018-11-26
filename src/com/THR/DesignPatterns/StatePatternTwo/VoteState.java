package com.THR.DesignPatterns.StatePatternTwo;

public interface VoteState {

    void voite(String user, String voteItem, VoteManager voteManager);
}
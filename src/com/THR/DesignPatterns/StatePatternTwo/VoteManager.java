package com.THR.DesignPatterns.StatePatternTwo;

import java.util.HashMap;
import java.util.Map;

public class VoteManager {

    private VoteState state = null;

    private Map<String, String> mapVote = new HashMap<>();
    private Map<String, Integer> mapVoteCount = new HashMap<>();

    public Map<String, String> getMapVote() {
        return mapVote;
    }

    public void vote(String user, String voteItem) {
        Integer preVoteCount = mapVoteCount.get(user);
        if (null == preVoteCount) {
            preVoteCount = 0;
        }
        mapVoteCount.put(user, ++preVoteCount);
        if (preVoteCount == 1){
            state = new NormalVoteState();
        } else if (preVoteCount > 1 && preVoteCount < 5){
            state = new RepeatVoteState();
        } else if (preVoteCount >= 5 && preVoteCount < 8){
            state = new SpiteVoteState();
        }else {
            state = new BlackVoteState();
        }
        state.voite(user, voteItem, this);
    }
}

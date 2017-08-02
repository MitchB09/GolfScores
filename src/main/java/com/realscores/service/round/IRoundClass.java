package com.realscores.service.round;

import java.util.List;

import com.realscores.obj.Round;

public interface IRoundClass {
	List<Round> getAllRounds();
	Round getRoundById(int roundId);
    boolean addRound(Round round);
    void updateRound(Round round);
    void deleteRound(int roundId);
}

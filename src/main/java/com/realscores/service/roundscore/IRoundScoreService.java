package com.realscores.service.roundscore;

import java.util.List;

import com.realscores.obj.Round;
import com.realscores.obj.RoundScore;

public interface IRoundScoreService {
	RoundScore getRoundScoreById(int roundScoreId);
	List<RoundScore> getRoundScoreByPlayerRoundId(int playerRoundId);
	List<RoundScore> getRoundScoresByRoundId(int roundId);
    boolean addRoundScore(RoundScore roundScore);
    void updateRoundScore(RoundScore roundScore);
    void deleteRoundScore(int roundScoreId);
}

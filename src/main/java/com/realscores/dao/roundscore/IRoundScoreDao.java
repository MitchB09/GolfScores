package com.realscores.dao.roundscore;

import java.util.List;

import com.realscores.obj.RoundScore;

public interface IRoundScoreDao {
	RoundScore getRoundScoreById(int roundScoreId);
	List<RoundScore> getRoundScoreByPlayerRoundId(int playerRoundId);
	List<RoundScore> getRoundScoresByRoundId(int roundId);
    void addRoundScore(RoundScore roundScore);
    void updateRoundScore(RoundScore roundScore);
    void deleteRoundScore(int roundScoreId);
    boolean RoundScoreExists(int playerRoundId, int holeId);
}

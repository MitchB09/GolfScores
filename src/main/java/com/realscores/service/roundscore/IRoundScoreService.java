package com.realscores.service.roundscore;

import java.util.List;

import com.realscores.obj.HoleScore;

public interface IRoundScoreService {
	HoleScore getRoundScoreById(int roundScoreId);
	List<HoleScore> getRoundScoreByPlayerRoundId(int playerRoundId);
	List<HoleScore> getRoundScoresByRoundId(int roundId);
    boolean addRoundScore(HoleScore holeScore);
    void updateRoundScore(HoleScore holeScore);
    void deleteRoundScore(int roundScoreId);
}

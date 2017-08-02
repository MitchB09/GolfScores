package com.realscores.service.roundscore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realscores.dao.roundscore.IRoundScoreDao;
import com.realscores.obj.RoundScore;

@Service
public class RoundScoreService implements IRoundScoreService {

	@Autowired
	private IRoundScoreDao roundScoreDao; 
	
	@Override
	public RoundScore getRoundScoreById(int roundScoreId) {
		return roundScoreDao.getRoundScoreById(roundScoreId);
	}

	@Override
	public List<RoundScore> getRoundScoreByPlayerRoundId(int playerRoundId) {
		return roundScoreDao.getRoundScoreByPlayerRoundId(playerRoundId);
	}

	@Override
	public List<RoundScore> getRoundScoresByRoundId(int roundId) {
		return roundScoreDao.getRoundScoresByRoundId(roundId);
	}

	@Override
	public boolean addRoundScore(RoundScore roundScore) {
		if (roundScoreDao.RoundScoreExists(roundScore.getPlayerRoundId(), roundScore.getHoleId())){
			return false;
		} else {
			roundScoreDao.addRoundScore(roundScore);
			return true;
		}
	}

	@Override
	public void updateRoundScore(RoundScore roundScore) {
		roundScoreDao.updateRoundScore(roundScore);
	}

	@Override
	public void deleteRoundScore(int roundScoreId) {
		roundScoreDao.deleteRoundScore(roundScoreId);
	}

}

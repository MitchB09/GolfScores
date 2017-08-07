package com.realscores.service.roundscore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realscores.dao.holescore.IHoleScoreDao;
import com.realscores.obj.HoleScore;

@Service
public class RoundScoreService implements IRoundScoreService {

	@Autowired
	private IHoleScoreDao holeScoreDao; 
	
	@Override
	public HoleScore getRoundScoreById(int roundScoreId) {
		return holeScoreDao.getRoundScoreById(roundScoreId);
	}

	@Override
	public List<HoleScore> getRoundScoreByPlayerRoundId(int playerRoundId) {
		return holeScoreDao.getRoundScoreByPlayerRoundId(playerRoundId);
	}

	@Override
	public List<HoleScore> getRoundScoresByRoundId(int roundId) {
		return holeScoreDao.getRoundScoresByRoundId(roundId);
	}

	@Override
	public boolean addRoundScore(HoleScore holeScore) {
		if (holeScoreDao.RoundScoreExists(holeScore.getPlayerRoundId(), holeScore.getHoleId())){
			return false;
		} else {
			holeScoreDao.addRoundScore(holeScore);
			return true;
		}
	}

	@Override
	public void updateRoundScore(HoleScore holeScore) {
		holeScoreDao.updateRoundScore(holeScore);
	}

	@Override
	public void deleteRoundScore(int roundScoreId) {
		holeScoreDao.deleteRoundScore(roundScoreId);
	}

}

package com.realscores.service.round;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realscores.dao.round.IRoundDao;
import com.realscores.obj.Round;

@Service
public class RoundService implements IRoundService {

	@Autowired
	private IRoundDao roundDao;
	
	@Override
	public List<Round> getAllRounds() {
		return roundDao.getAllRounds();
	}

	@Override
	public Round getRoundById(int roundId) {
		return roundDao.getRoundById(roundId);
	}

	@Override
	public boolean addRound(Round round) {
		if (roundDao.roundExists(round.getId())){
			return false;
		} else {
			roundDao.addRound(round);
			return true;
		}
	}

	@Override
	public void updateRound(Round round) {
		roundDao.updateRound(round);
	}

	@Override
	public void deleteRound(int roundId) {
		roundDao.deleteRound(roundId);
	}

}

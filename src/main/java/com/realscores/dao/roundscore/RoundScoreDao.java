package com.realscores.dao.roundscore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.realscores.obj.RoundScore;

@Transactional
@Repository
public class RoundScoreDao implements IRoundScoreDao {

	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public RoundScore getRoundScoreById(int roundScoreId) {
		return entityManager.find(RoundScore.class, roundScoreId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<RoundScore> getRoundScoreByPlayerRoundId(int playerRoundId) {
		String hql = "FROM Round_score as rdsc WHERE rdsc.player_round_id = ?";
		List<RoundScore> roundScores = entityManager.createQuery(hql).setParameter(1, playerRoundId)
		              .getResultList();
		return roundScores;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RoundScore> getRoundScoresByRoundId(int roundId) {
		String hql = 
				"SELECT * FROM round_score AS rdsc " +
				"INNER JOIN player_round plrd ON rdsc.player_round_id = plrd.player_round_id " +
				"WHERE plrd.round_id = ?";
		List<RoundScore> roundScores = entityManager.createQuery(hql).setParameter(1, roundId)
						.getResultList();
		return roundScores;
	}
	
	@Override
	public void addRoundScore(RoundScore roundScore) {
		entityManager.persist(roundScore);
	}

	@Override
	public void updateRoundScore(RoundScore roundScore) {
		RoundScore foundRoundScore = getRoundScoreById(roundScore.getPlayerRoundId());
		foundRoundScore.setHoleId(roundScore.getHoleId());
		foundRoundScore.setScore(roundScore.getScore());
		foundRoundScore.setGIR(roundScore.isGIR());
		foundRoundScore.setFairwayHit(roundScore.getFairwayHit());
		foundRoundScore.setPutts(roundScore.getPutts());
		entityManager.flush();
	}

	@Override
	public void deleteRoundScore(int roundScoreId) {
		entityManager.remove(getRoundScoreById(roundScoreId));
	}

	@Override
	public boolean RoundScoreExists(int playerRoundId, int holeId) {
		String hql = "FROM Round_score as rdsc WHERE rdsc.player_round_id = ? AND rdsc.hole_id = ?";
		int count = entityManager.createQuery(hql).setParameter(1, playerRoundId).setParameter(2, holeId)
		              .getResultList().size();
		return count > 0 ? true : false;
	}

}

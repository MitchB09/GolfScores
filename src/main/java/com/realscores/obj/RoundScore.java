package com.realscores.obj;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="round_score")
public class RoundScore implements Serializable{

	private static final long serialVersionUID = -6778088324391438214L;

	@Id
	@ManyToOne(targetEntity = PlayerRound.class)
	@JoinColumn(name="player_round_id")
	private int playerRoundId;
	
	@ManyToOne(targetEntity = Hole.class)
	@JoinColumn(name="hole_id")
	private int holeId;
	
	@Column(name="score")
	private int score;
	
	@Column(name="gir")
	private boolean GIR;
	
	@Column(name="fairway")
	private int fairwayHit;
	
	@Column(name="putts")
	private int putts;

	public int getPlayerRoundId() {
		return playerRoundId;
	}

	public void setPlayerRoundId(int playerRoundId) {
		this.playerRoundId = playerRoundId;
	}

	public int getHoleId() {
		return holeId;
	}

	public void setHoleId(int holeId) {
		this.holeId = holeId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isGIR() {
		return GIR;
	}

	public void setGIR(boolean gIR) {
		GIR = gIR;
	}

	public int getFairwayHit() {
		return fairwayHit;
	}

	public void setFairwayHit(int fairwayHit) {
		this.fairwayHit = fairwayHit;
	}

	public int getPutts() {
		return putts;
	}

	public void setPutts(int putts) {
		this.putts = putts;
	}
}

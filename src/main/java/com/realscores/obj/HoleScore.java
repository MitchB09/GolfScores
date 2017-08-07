package com.realscores.obj;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="round_score")
public class HoleScore implements Serializable{

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
	@Enumerated(EnumType.ORDINAL)
	private FairwayHitEnum fairwayHit;
	
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

	public void setGIR(boolean GIR) {
		this.GIR = GIR;
	}

	public FairwayHitEnum getFairwayHit() {
		return fairwayHit;
	}

	public void setFairwayHit(FairwayHitEnum fairwayHit) {
		this.fairwayHit = fairwayHit;
	}

	public int getPutts() {
		return putts;
	}

	public void setPutts(int putts) {
		this.putts = putts;
	}
}

package com.realscores.obj;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="player_round")
public class PlayerRound implements Serializable{

	private static final long serialVersionUID = -7642795917197186404L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="player_round_id")
	private int id;
	
	@ManyToOne(targetEntity = Player.class)
	@JoinColumn(name="player_id")
	private int playerId;
	
	@ManyToOne(targetEntity = Round.class)
	@JoinColumn(name="round_id")
	private int roundId;
	
	@OneToMany
	private List<RoundScore> roundScores;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getRoundId() {
		return roundId;
	}

	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}
}

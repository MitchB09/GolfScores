package com.realscores.obj;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="player_round")
public class PlayerRound implements Serializable{

	private static final long serialVersionUID = -7642795917197186404L;

	@Column(name="round_id")
	private int round_id;
	
	@Column(name="player_id")
	private int player_id;
	
	@Column(name="player_round_id")
	private int player_round_id;

	public int getRound_id() {
		return round_id;
	}

	public void setRound_id(int round_id) {
		this.round_id = round_id;
	}

	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}

	public int getPlayer_round_id() {
		return player_round_id;
	}

	public void setPlayer_round_id(int player_round_id) {
		this.player_round_id = player_round_id;
	}

}

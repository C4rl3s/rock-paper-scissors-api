package com.challenge.rockpaperscissors.model.match;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MATCH")
public class Match {

	@Id
	@Column(name = "match_datetime")
	private LocalDateTime matchDateTime;

	@Column(name = "player_move", length = 20)
	private String playerMove;

	@Column(name = "computer_move", length = 20)
	private String computerMove;

	@Column(name = "result", length = 20)
	private String result;

	public String getPlayerMove() {
		return playerMove;
	}

	public void setPlayerMove(String playerMove) {
		this.playerMove = playerMove;
	}

	public String getComputerMove() {
		return computerMove;
	}

	public void setComputerMove(String computerMove) {
		this.computerMove = computerMove;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public LocalDateTime getMatchDateTime() {
		return matchDateTime;
	}

	public void setMatchDateTime(LocalDateTime matchDateTime) {
		this.matchDateTime = matchDateTime;
	}

}

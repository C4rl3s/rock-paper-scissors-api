package com.challenge.rockpaperscissors.dto.match;

import java.time.LocalDateTime;

public class MatchDto {

	private String playerMove;

	private String computerMove;

	private String result;

	private LocalDateTime matchDateTime;

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

	@Override
	public boolean equals(Object match) {
		return playerMove.equals(((MatchDto) match).getPlayerMove())
				&& computerMove.equals(((MatchDto) match).getComputerMove())
				&& result.equals(((MatchDto) match).getResult())
				&& matchDateTime.equals(((MatchDto) match).getMatchDateTime());
	}

}

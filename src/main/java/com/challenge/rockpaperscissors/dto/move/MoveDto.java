package com.challenge.rockpaperscissors.dto.move;

public class MoveDto {

	private String move;

	public String getMove() {
		return move;
	}

	public void setMove(String move) {
		this.move = move;
	}

	public boolean equals(Object moveDto) {
		return move.equals(((MoveDto) moveDto).getMove());
	}
}

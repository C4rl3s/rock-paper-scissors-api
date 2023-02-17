package com.challenge.rockpaperscissors.model.move;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MOVE")
public class Move {

	@Id
	@Column(name = "move", length = 20)
	private String move;

	public String getMove() {
		return move;
	}

	public void setMove(String move) {
		this.move = move;
	}

}

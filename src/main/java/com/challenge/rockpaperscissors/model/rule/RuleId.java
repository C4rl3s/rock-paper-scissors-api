package com.challenge.rockpaperscissors.model.rule;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class RuleId implements Serializable {

	public RuleId(String playerMove, String computerMove) {
		this.playerMove = playerMove;
		this.computerMove = computerMove;
	}

	@Column(name = "player_move", length = 20)
	private String playerMove;

	@Column(name = "computer_move", length = 20)
	private String computerMove;
}

package com.challenge.rockpaperscissors.dto.match;

public class MatchSummaryDto {

	private Integer wins;

	private Integer losses;

	private Integer draws;

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getLosses() {
		return losses;
	}

	public void setLosses(Integer losses) {
		this.losses = losses;
	}

	public Integer getDraws() {
		return draws;
	}

	public void setDraws(Integer draws) {
		this.draws = draws;
	}

	@Override
	public boolean equals(Object summary) {
		return wins.equals(((MatchSummaryDto) summary).getWins())
				&& losses.equals(((MatchSummaryDto) summary).getLosses())
				&& draws.equals(((MatchSummaryDto) summary).getDraws());

	}

}

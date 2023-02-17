package com.challenge.rockpaperscissors.model.rule;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "RULE")
public class Rule {

	@EmbeddedId
	private RuleId id;

	@Column(name = "result", length = 20)
	private String result;

	public String getResult() {
		return result;
	}
}

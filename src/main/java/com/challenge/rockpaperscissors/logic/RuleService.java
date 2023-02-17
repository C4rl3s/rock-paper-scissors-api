package com.challenge.rockpaperscissors.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.rockpaperscissors.model.rule.RuleId;
import com.challenge.rockpaperscissors.repository.RuleRepository;

@Service
public class RuleService {

	@Autowired
	private RuleRepository ruleRepository;

	public String getPlayResultByMoves(String playerMove, String computerMove) {
		RuleId id = new RuleId(playerMove, computerMove);

		return ruleRepository.getReferenceById(id).getResult();
	}
}

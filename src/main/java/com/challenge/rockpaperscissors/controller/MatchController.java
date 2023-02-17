package com.challenge.rockpaperscissors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.rockpaperscissors.dto.match.MatchDto;
import com.challenge.rockpaperscissors.dto.match.MatchSummaryDto;
import com.challenge.rockpaperscissors.exception.MoveNotFoundException;
import com.challenge.rockpaperscissors.logic.MatchService;

@RestController
@RequestMapping("/match")
public class MatchController {

	@Autowired
	private MatchService matchService;

	@GetMapping("/play/{playerMove}")
	public ResponseEntity<MatchDto> playMatch(@PathVariable("playerMove") String playerMove)
			throws MoveNotFoundException {

		return new ResponseEntity<>(matchService.playMatch(playerMove), HttpStatus.OK);
	}

	@GetMapping("/summary/")
	public ResponseEntity<MatchSummaryDto> getMatchSummary() {

		return new ResponseEntity<MatchSummaryDto>(matchService.getMatchSummary(), HttpStatus.OK);
	}
}

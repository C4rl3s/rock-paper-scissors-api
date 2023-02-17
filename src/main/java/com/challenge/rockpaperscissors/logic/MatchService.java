package com.challenge.rockpaperscissors.logic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.rockpaperscissors.dto.match.MatchDto;
import com.challenge.rockpaperscissors.dto.match.MatchSummaryDto;
import com.challenge.rockpaperscissors.dto.move.MoveDto;
import com.challenge.rockpaperscissors.exception.MoveNotFoundException;
import com.challenge.rockpaperscissors.mapper.MatchDtoMapper;
import com.challenge.rockpaperscissors.model.match.Match;
import com.challenge.rockpaperscissors.repository.MatchRepository;

@Service
public class MatchService {

	private final Long DEFAULT_VALUE = 0L;

	@Autowired
	private RuleService ruleService;

	@Autowired
	private MoveService moveService;

	@Autowired
	private MatchRepository matchRepository;

	public MatchDto playMatch(String playerMove) throws MoveNotFoundException {

		checkMoveExists(playerMove);

		String computerMove = getRandomComputerMove();
		String playResult = ruleService.getPlayResultByMoves(playerMove, computerMove);
		LocalDateTime timeOfMatch = LocalDateTime.now();

		Match entity = buildMatchEntity(playerMove, computerMove, playResult, timeOfMatch);

		return MatchDtoMapper.fromEntityToDto(matchRepository.save(entity));
	}

	private void checkMoveExists(String playerMove) throws MoveNotFoundException {
		if (!moveService.existByMove(playerMove)) {
			throw new MoveNotFoundException();
		}
	}

	private Match buildMatchEntity(String playerMove, String computerMove, String playResult,
			LocalDateTime timeOfMatch) {
		Match entity = new Match();
		entity.setPlayerMove(playerMove);
		entity.setComputerMove(computerMove);
		entity.setResult(playResult);
		entity.setMatchDateTime(timeOfMatch);

		return entity;
	}

	private String getRandomComputerMove() {
		List<MoveDto> possibleMoves = moveService.getAllMoves();

		Random rand = new Random();

		return possibleMoves.get(rand.nextInt(possibleMoves.size())).getMove();
	}

	public MatchSummaryDto getMatchSummary() {
		Map<String, Long> matchResults = matchRepository.findAll().stream()
				.collect(Collectors.groupingBy(Match::getResult, Collectors.counting()));

		var summaryDto = new MatchSummaryDto();
		summaryDto.setWins(matchResults.getOrDefault("Player", DEFAULT_VALUE).intValue());
		summaryDto.setLosses(matchResults.getOrDefault("Computer", DEFAULT_VALUE).intValue());
		summaryDto.setDraws(matchResults.getOrDefault("Draw", DEFAULT_VALUE).intValue());

		return summaryDto;
	}
}

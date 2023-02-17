package com.challenge.rockpaperscissors.match;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.challenge.rockpaperscissors.dto.match.MatchDto;
import com.challenge.rockpaperscissors.dto.match.MatchSummaryDto;
import com.challenge.rockpaperscissors.dto.move.MoveDto;
import com.challenge.rockpaperscissors.exception.MoveNotFoundException;
import com.challenge.rockpaperscissors.logic.MatchService;
import com.challenge.rockpaperscissors.logic.MoveService;
import com.challenge.rockpaperscissors.logic.RuleService;
import com.challenge.rockpaperscissors.model.match.Match;
import com.challenge.rockpaperscissors.repository.MatchRepository;

@ExtendWith(MockitoExtension.class)
public class MatchTest {

	private static final String PLAYER_MOVE = "Rock";
	private static final String COMPUTER_MOVE = "Rock";
	private static final String PLAY_RESULT = "Draw";
	private static final Integer WINS_LOSSES_COUNT = 0;
	private static final Integer DRAWS_COUNT = 1;
	private static final String NOT_VALID_MOVE = "Gomu-Gomu no Pistol";

	@InjectMocks
	private MatchService matchService;

	@Mock
	private RuleService ruleService;

	@Mock
	private MoveService moveService;

	@Mock
	private MatchRepository matchRepository;

	private Match matchEntity;
	private MatchDto matchDto;

	@BeforeEach
	public void setUp() {
		LocalDateTime timeOfMatch = LocalDateTime.now();

		matchEntity = new Match();
		matchEntity.setPlayerMove(PLAYER_MOVE);
		matchEntity.setComputerMove(COMPUTER_MOVE);
		matchEntity.setResult(PLAY_RESULT);
		matchEntity.setMatchDateTime(timeOfMatch);

		matchDto = new MatchDto();
		matchDto.setPlayerMove(PLAYER_MOVE);
		matchDto.setComputerMove(COMPUTER_MOVE);
		matchDto.setResult(PLAY_RESULT);
		matchDto.setMatchDateTime(timeOfMatch);
	}

	@Test
	public void playMatchShouldSaveMatch() throws MoveNotFoundException {

		MoveDto move = new MoveDto();
		move.setMove(COMPUTER_MOVE);
		List<MoveDto> possibleMoves = new ArrayList<>();
		possibleMoves.add(move);

		when(moveService.existByMove(Mockito.any())).thenReturn(true);
		when(moveService.getAllMoves()).thenReturn(possibleMoves);
		when(ruleService.getPlayResultByMoves(PLAYER_MOVE, COMPUTER_MOVE)).thenReturn(PLAY_RESULT);
		when(matchRepository.save(Mockito.any())).thenReturn(matchEntity);

		assertThat(matchDto).isEqualTo(matchService.playMatch(PLAYER_MOVE));
	}

	@Test
	public void playMatchWithNotValidMoveShouldThrowException() {

		when(moveService.existByMove(NOT_VALID_MOVE)).thenReturn(false);

		assertThrows(MoveNotFoundException.class, () -> matchService.playMatch(NOT_VALID_MOVE));
	}

	@Test
	public void getMatchSummaryShouldReturnSummaryDto() {
		List<Match> matchesList = new ArrayList<>();
		matchesList.add(matchEntity);

		var summaryDto = new MatchSummaryDto();
		summaryDto.setWins(WINS_LOSSES_COUNT);
		summaryDto.setLosses(WINS_LOSSES_COUNT);
		summaryDto.setDraws(DRAWS_COUNT);

		when(matchRepository.findAll()).thenReturn(matchesList);

		assertThat(summaryDto).isEqualTo(matchService.getMatchSummary());
	}

}

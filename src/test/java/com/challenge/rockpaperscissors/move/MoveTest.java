package com.challenge.rockpaperscissors.move;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.challenge.rockpaperscissors.dto.move.MoveDto;
import com.challenge.rockpaperscissors.logic.MoveService;
import com.challenge.rockpaperscissors.model.move.Move;
import com.challenge.rockpaperscissors.repository.MoveRepository;

@ExtendWith(MockitoExtension.class)
public class MoveTest {

	private static final String MOVE = "Rock";

	@InjectMocks
	private MoveService moveService;

	@Mock
	private MoveRepository moveRepository;

	@Test
	public void getAllMovesShouldRetrieveMoveList() {

		Move moveEntity = new Move();
		moveEntity.setMove(MOVE);
		List<Move> possibleMovesEntityList = new ArrayList<>();
		possibleMovesEntityList.add(moveEntity);

		MoveDto moveDto = new MoveDto();
		moveDto.setMove(MOVE);
		List<MoveDto> possibleMovesDtoList = new ArrayList<>();
		possibleMovesDtoList.add(moveDto);

		when(moveRepository.findAll()).thenReturn(possibleMovesEntityList);

		assertThat(possibleMovesDtoList).isEqualTo(moveService.getAllMoves());
	}

}

package com.challenge.rockpaperscissors.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.challenge.rockpaperscissors.dto.move.MoveDto;
import com.challenge.rockpaperscissors.model.move.Move;

public class MoveDtoMapper {

	public static MoveDto fromEntityToDto(Move entity) {

		MoveDto moveDto = new MoveDto();
		moveDto.setMove(entity.getMove());

		return moveDto;
	}

	public static List<MoveDto> fromEntityToDtoList(List<Move> entities) {

		return entities.stream().map(entity -> fromEntityToDto(entity)).collect(Collectors.toList());
	}
}

package com.challenge.rockpaperscissors.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.challenge.rockpaperscissors.dto.match.MatchDto;
import com.challenge.rockpaperscissors.model.match.Match;

public class MatchDtoMapper {

	public static MatchDto fromEntityToDto(Match entity) {

		MatchDto matchDto = new MatchDto();
		matchDto.setPlayerMove(entity.getPlayerMove());
		matchDto.setComputerMove(entity.getComputerMove());
		matchDto.setResult(entity.getResult());
		matchDto.setMatchDateTime(entity.getMatchDateTime());

		return matchDto;
	}

	public static List<MatchDto> fromEntityToDtoList(List<Match> entities) {

		return entities.stream().map(entity -> fromEntityToDto(entity)).collect(Collectors.toList());
	}
}

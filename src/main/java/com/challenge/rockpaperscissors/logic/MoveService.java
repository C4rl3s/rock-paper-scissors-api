package com.challenge.rockpaperscissors.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.rockpaperscissors.dto.move.MoveDto;
import com.challenge.rockpaperscissors.mapper.MoveDtoMapper;
import com.challenge.rockpaperscissors.repository.MoveRepository;

@Service
public class MoveService {

	@Autowired
	private MoveRepository moveRepository;

	public List<MoveDto> getAllMoves() {
		return MoveDtoMapper.fromEntityToDtoList(moveRepository.findAll());
	}

	public boolean existByMove(String move) {
		return moveRepository.existsById(move);
	}
}

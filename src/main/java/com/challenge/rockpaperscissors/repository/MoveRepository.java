package com.challenge.rockpaperscissors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.rockpaperscissors.model.move.Move;

@Repository
public interface MoveRepository extends JpaRepository<Move, String> {

}

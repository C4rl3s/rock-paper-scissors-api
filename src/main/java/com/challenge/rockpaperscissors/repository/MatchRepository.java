package com.challenge.rockpaperscissors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.rockpaperscissors.model.match.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}

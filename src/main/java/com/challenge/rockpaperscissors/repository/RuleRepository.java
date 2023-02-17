package com.challenge.rockpaperscissors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.rockpaperscissors.model.rule.Rule;
import com.challenge.rockpaperscissors.model.rule.RuleId;

@Repository
public interface RuleRepository extends JpaRepository<Rule, RuleId> {
}

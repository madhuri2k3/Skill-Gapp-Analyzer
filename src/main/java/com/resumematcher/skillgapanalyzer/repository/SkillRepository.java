package com.resumematcher.skillgapanalyzer.repository;

import com.resumematcher.skillgapanalyzer.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}

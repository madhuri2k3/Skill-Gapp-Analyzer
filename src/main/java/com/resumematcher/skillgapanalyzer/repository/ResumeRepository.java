package com.resumematcher.skillgapanalyzer.repository;

import com.resumematcher.skillgapanalyzer.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}

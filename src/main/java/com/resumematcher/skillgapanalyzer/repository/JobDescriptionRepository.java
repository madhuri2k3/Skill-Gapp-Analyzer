package com.resumematcher.skillgapanalyzer.repository;

import com.resumematcher.skillgapanalyzer.model.JobDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDescriptionRepository extends JpaRepository<JobDescription, Long> {
}

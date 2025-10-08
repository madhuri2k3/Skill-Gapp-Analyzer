package com.resumematcher.skillgapanalyzer.repository;

import com.resumematcher.skillgapanalyzer.model.JobDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDescriptionRepository extends JpaRepository<JobDescription, Long> {
}

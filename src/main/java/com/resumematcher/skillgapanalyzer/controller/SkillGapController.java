package com.resumematcher.skillgapanalyzer.controller;

import com.resumematcher.skillgapanalyzer.model.Resume;
import com.resumematcher.skillgapanalyzer.model.JobDescription;
import com.resumematcher.skillgapanalyzer.repository.ResumeRepository;
import com.resumematcher.skillgapanalyzer.repository.JobDescriptionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/skillgap")
public class SkillGapController {

    private final ResumeRepository resumeRepository;
    private final JobDescriptionRepository jobRepository;

    public SkillGapController(ResumeRepository resumeRepository, JobDescriptionRepository jobRepository) {
        this.resumeRepository = resumeRepository;
        this.jobRepository = jobRepository;
    }

    @GetMapping("/{resumeId}/{jobId}")
    public ResponseEntity<?> findSkillGap(@PathVariable Long resumeId, @PathVariable Long jobId) {
        Optional<Resume> resumeOpt = resumeRepository.findById(resumeId);
        Optional<JobDescription> jobOpt = jobRepository.findById(jobId);

        if (resumeOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("❌ Resume not found with id: " + resumeId);
        }
        if (jobOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("❌ Job not found with id: " + jobId);
        }

        Resume resume = resumeOpt.get();
        JobDescription job = jobOpt.get();

        // Use getSkillsList() to get List<String>
        Set<String> resumeSkills = new HashSet<>(resume.getSkillsList());
        Set<String> jobSkills = new HashSet<>(job.getRequiredSkillsList());

        // Missing skills = job requires but resume doesn’t have
        Set<String> missingSkills = new HashSet<>(jobSkills);
        missingSkills.removeAll(resumeSkills);

        // Matching skills = both have
        Set<String> matchingSkills = new HashSet<>(resumeSkills);
        matchingSkills.retainAll(jobSkills);

        // Match percentage
        int matchPercentage = (int) ((matchingSkills.size() * 100.0) / jobSkills.size());

        Map<String, Object> response = new HashMap<>();
        response.put("candidate", resume.getCandidateName());
        response.put("jobTitle", job.getJobTitle());
        response.put("matchingSkills", matchingSkills);
        response.put("missingSkills", missingSkills);
        response.put("matchPercentage", matchPercentage);

        return ResponseEntity.ok(response);
    }
}

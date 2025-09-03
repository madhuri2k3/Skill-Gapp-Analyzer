package com.resumematcher.skillgapanalyzer.controller;

import com.resumematcher.skillgapanalyzer.model.JobDescription;
import com.resumematcher.skillgapanalyzer.repository.JobDescriptionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobDescriptionController {

    private final JobDescriptionRepository jobRepository;

    public JobDescriptionController(JobDescriptionRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @PostMapping
    public JobDescription addJob(@RequestBody JobDescription jobDescription) {
        return jobRepository.save(jobDescription);
    }

    @GetMapping
    public List<JobDescription> getAllJobs() {
        return jobRepository.findAll();
    }
}

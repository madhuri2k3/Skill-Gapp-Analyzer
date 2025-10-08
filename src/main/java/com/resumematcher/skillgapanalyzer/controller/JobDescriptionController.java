package com.resumematcher.skillgapanalyzer.controller;

import com.resumematcher.skillgapanalyzer.model.JobDescription;
import com.resumematcher.skillgapanalyzer.repository.JobDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobdescriptions")
@CrossOrigin(origins = "http://localhost:5173")  // allow frontend to call this API
public class JobDescriptionController {

    @Autowired
    private JobDescriptionRepository jobDescriptionRepository;

    // Get all job descriptions
    @GetMapping
    public List<JobDescription> getAllJobDescriptions() {
        return jobDescriptionRepository.findAll();
    }
}

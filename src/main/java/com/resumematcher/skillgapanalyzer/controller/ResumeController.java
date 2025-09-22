package com.resumematcher.skillgapanalyzer.controller;

import com.resumematcher.skillgapanalyzer.model.Resume;
import com.resumematcher.skillgapanalyzer.repository.ResumeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    private final ResumeRepository resumeRepository;

    public ResumeController(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @PostMapping
    public Resume addResume(@RequestBody Resume resume) {
        return resumeRepository.save(resume);
    }

    @GetMapping
    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }
}

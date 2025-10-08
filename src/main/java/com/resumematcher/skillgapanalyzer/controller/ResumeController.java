package com.resumematcher.skillgapanalyzer.controller;

import com.resumematcher.skillgapanalyzer.model.Resume;
import com.resumematcher.skillgapanalyzer.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    @Autowired
    private ResumeRepository resumeRepository;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadResume(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("❌ File is empty");
        }

        // Here we simulate storing resume; in real app, you can extract text or parse skills
        Resume resume = new Resume();
        resume.setCandidateName(file.getOriginalFilename()); // temporary, replace with real name
        resume.setSkills(file.getOriginalFilename()); // temporary placeholder
        resumeRepository.save(resume);

        return ResponseEntity.ok(resume.getId());
    }
}

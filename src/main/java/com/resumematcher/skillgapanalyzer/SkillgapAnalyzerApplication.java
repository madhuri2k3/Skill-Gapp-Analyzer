package com.resumematcher.skillgapanalyzer;

import com.resumematcher.skillgapanalyzer.model.Resume;
import com.resumematcher.skillgapanalyzer.model.JobDescription;
import com.resumematcher.skillgapanalyzer.repository.ResumeRepository;
import com.resumematcher.skillgapanalyzer.repository.JobDescriptionRepository;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SkillgapAnalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkillgapAnalyzerApplication.class, args);
    }

   @Bean
CommandLineRunner initData(ResumeRepository resumeRepo, JobDescriptionRepository jobRepo) {
    return args -> {
        if (resumeRepo.count() == 0) {
            Resume r = new Resume();
            r.setId(1L);
            r.setCandidateName("Madhuri");
            r.setSkills("Java,Spring Boot,SQL"); // ✅ comma-separated string
            resumeRepo.save(r);
        }

        if (jobRepo.count() == 0) {
            JobDescription j = new JobDescription();
            j.setId(1L);
            j.setJobTitle("Java Developer");
            j.setRequiredSkills("Java,Spring Boot,React,SQL"); // ✅ comma-separated string
            jobRepo.save(j);
        }
    };
}
}
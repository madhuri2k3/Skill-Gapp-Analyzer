package com.resumematcher.skillgapanalyzer.model;

import jakarta.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class JobDescription {

    @Id
    private Long id;

    private String jobTitle;

    // Store required skills as comma-separated string
    private String requiredSkills;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    // Convenience method to get required skills as a List<String>
    public List<String> getRequiredSkillsList() {
        if (requiredSkills == null || requiredSkills.isEmpty()) {
            return List.of();
        }
        return Arrays.asList(requiredSkills.split(","));
    }
}

package com.resumematcher.skillgapanalyzer.model;

import jakarta.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class JobDescription {

    @Id
    private Long id;

    private String jobTitle;

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

    public List<String> getRequiredSkillsList() {
        return Arrays.asList(requiredSkills.split(","));
    }
}

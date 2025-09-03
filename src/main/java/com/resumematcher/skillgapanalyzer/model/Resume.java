package com.resumematcher.skillgapanalyzer.model;

import jakarta.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Resume {

    @Id
    private Long id;

    private String candidateName;

    // Store skills as comma-separated string
    private String skills;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    // Convenience method to get skills as a List
    public List<String> getSkillsList() {
        return Arrays.asList(skills.split(","));
    }
}

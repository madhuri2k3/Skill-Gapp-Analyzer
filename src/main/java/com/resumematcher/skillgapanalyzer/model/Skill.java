// package com.resumematcher.skillgap_analyzer;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class SkillgapAnalyzerApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(SkillgapAnalyzerApplication.class, args);
// 	}

// }
package com.resumematcher.skillgapanalyzer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Skill() {}

    public Skill(String name) {
        this.name = name;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

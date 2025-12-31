package com.dolittel.jobPotal.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Which job are they applying for?
    private Long jobId;

    // Candidate Details
    private String applicantName;
    private String applicantEmail;
    
    @Column(columnDefinition = "TEXT")
    private String coverLetter;

    // We will store the URL of the resume file here later
    private String resumeUrl; 

    private LocalDateTime appliedAt;

    @PrePersist
    protected void onCreate() {
        appliedAt = LocalDateTime.now();
    }
}
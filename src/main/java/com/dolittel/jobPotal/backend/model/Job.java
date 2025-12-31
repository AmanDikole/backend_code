package com.dolittel.jobPotal.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Tells Hibernate to make a table out of this class
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-Increment ID
    private Long id;

    private String title;
    private String companyName;
    private String location;
    private Double salaryMin;
    private Double salaryMax;
    private String jobType; // e.g., "Full Time", "Remote"

    @Column(columnDefinition = "TEXT") // Allows long text (more than 255 chars)
    private String description;

    @Column(columnDefinition = "TEXT")
    private String requirements;

    private LocalDateTime postedAt;

    // This runs automatically before saving to DB
    @PrePersist
    protected void onCreate() {
        postedAt = LocalDateTime.now();
    }

    // --- Getters and Setters (Since you might not have Lombok set up yet) ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Double getSalaryMin() { return salaryMin; }
    public void setSalaryMin(Double salaryMin) { this.salaryMin = salaryMin; }

    public Double getSalaryMax() { return salaryMax; }
    public void setSalaryMax(Double salaryMax) { this.salaryMax = salaryMax; }

    public String getJobType() { return jobType; }
    public void setJobType(String jobType) { this.jobType = jobType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getRequirements() { return requirements; }
    public void setRequirements(String requirements) { this.requirements = requirements; }

    public LocalDateTime getPostedAt() { return postedAt; }
    public void setPostedAt(LocalDateTime postedAt) { this.postedAt = postedAt; }
}

package com.dolittel.jobPotal.backend.controller;

import com.dolittel.jobPotal.backend.model.Application;
import com.dolittel.jobPotal.backend.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "http://localhost:3001") // Allow Next.js
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    // 1. Candidate applies for a job
    @PostMapping
    public Application applyForJob(@RequestBody Application application) {
        // Here we just save the text data. 
        // (File upload logic is complex, we will add it in the next step if you want)
        return applicationRepository.save(application);
    }

    // 2. Recruiter views applicants for a specific job
    @GetMapping("/job/{jobId}")
    public List<Application> getApplicationsByJob(@PathVariable Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }
}
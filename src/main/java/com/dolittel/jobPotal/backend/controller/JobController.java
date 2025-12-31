package com.dolittel.jobPotal.backend.controller;

import com.dolittel.jobPotal.backend.model.Job;
import com.dolittel.jobPotal.backend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs") // This sets the URL to http://localhost:8080/api/jobs
@CrossOrigin(origins = "http://localhost:3001") // IMPORTANT: Allows Next.js to access this
public class JobController {

    @Autowired
    private JobService jobService;

    // GET request: Returns all jobs
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    // POST request: Creates a new job
    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    // GET request: Returns one job by ID
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id).orElse(null);
    }
}
package com.dolittel.jobPotal.backend.service;

import com.dolittel.jobPotal.backend.model.Job;
import com.dolittel.jobPotal.backend.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // 1. Get all jobs from the database
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // 2. Save a new job to the database
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    // 3. Find a single job by ID
    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }
}
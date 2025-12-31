package com.dolittel.jobPotal.backend.repository;

import com.dolittel.jobPotal.backend.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    // This gives us ready-to-use methods like save(), findAll(), delete(), etc.
}
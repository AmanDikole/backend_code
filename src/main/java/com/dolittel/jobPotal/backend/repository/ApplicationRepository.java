package com.dolittel.jobPotal.backend.repository;

import com.dolittel.jobPotal.backend.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    // Find all applications for a specific job (Useful for Recruiter Dashboard)
    List<Application> findByJobId(Long jobId);
}
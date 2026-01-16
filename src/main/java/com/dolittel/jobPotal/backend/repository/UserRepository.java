package com.dolittel.jobPotal.backend.repository;

import com.dolittel.jobPotal.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // Used for Login: "Find user where email = ?"
    Optional<User> findByEmail(String email);

    // Used for Registration: "Does this email already exist?"
    Boolean existsByEmail(String email);
}
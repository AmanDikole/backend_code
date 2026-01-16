package com.dolittel.jobPotal.backend.controller;

import com.dolittel.jobPotal.backend.model.User;
import com.dolittel.jobPotal.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3001") // Ensure this matches your Next.js port (usually 3000)
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // --- 1. REGISTRATION ---
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email is already in use!");
        }
        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }

    // --- 2. LOGIN ---
    
    // A small helper to hold the incoming JSON data { "email": "...", "password": "..." }
    record LoginRequest(String email, String password) {}

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        
        // Step A: Find the user by email
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.email());
        
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            
            // Step B: Check if the password matches the hash in the DB
            if (passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
                
                // Step C: Create a clean response (Do NOT send the password back!)
                Map<String, String> response = new HashMap<>();
                response.put("id", String.valueOf(user.getId()));
                response.put("fullName", user.getFullName());
                response.put("email", user.getEmail());
                response.put("role", user.getRole());
                
                return ResponseEntity.ok(response);
            }
        }
        
        // Step D: If email not found OR password wrong
        return ResponseEntity.status(401).body("Invalid Email or Password");
    }
}
package com.natural.controller.authController;

import com.natural.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Auth {

    @Autowired
    private LoginService loginService;

    // Endpoint for sending the verification code
    @PostMapping("/send-verification-code")
    public ResponseEntity<String> sendVerificationCode(@RequestParam String email) {
        boolean isSent = loginService.sendVerificationCode(email);
        if (isSent) {
            return ResponseEntity.ok("Verification code sent to your email.");
        } else {
            return ResponseEntity.status(404).body("Email not found.");
        }
    }

    // Endpoint for login with verification code
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String verificationCode) {
        boolean isAuthenticated = loginService.authenticate(email, password, verificationCode);
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials or verification code.");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String name) {
        boolean isRegistered = loginService.register(email, password, name);
        if (isRegistered) {
            return ResponseEntity.ok("Registration successful!");
        } else {
            return ResponseEntity.status(409).body("Email already exists.");
        }
    }
}

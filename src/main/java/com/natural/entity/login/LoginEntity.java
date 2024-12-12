package com.natural.entity.login;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class LoginEntity {

    @Id
    private String email;
    private String password;
    private String name;
    private String verificationCode;
    private LocalDateTime verificationCodeExpiry;


    public LoginEntity() {
        // Default constructor
    }

    public LoginEntity(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return  name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public LocalDateTime getVerificationCodeExpiry() {
        return verificationCodeExpiry;
    }

    public void setVerificationCodeExpiry(LocalDateTime verificationCodeExpiry) {
        this.verificationCodeExpiry = verificationCodeExpiry;
    }

}

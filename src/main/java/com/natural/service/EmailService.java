package com.natural.service;


public interface EmailService {
    void sendVerificationCode(String email, String verificationCode);
}

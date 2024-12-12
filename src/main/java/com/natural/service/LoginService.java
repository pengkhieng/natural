package com.natural.service;

public interface LoginService {
    boolean register(String email, String password, String name);
    boolean authenticate(String email, String password, String verificationCode);
    boolean sendVerificationCode(String email);
    boolean verifyCode(String email, String verificationCode);
}

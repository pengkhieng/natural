package com.natural.service.serviceImpl;

import com.natural.entity.login.LoginEntity;
import com.natural.repository.login.LoginRepository;
import com.natural.service.EmailService;
import com.natural.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public boolean authenticate(String email, String password, String verificationCode) {
        LoginEntity loginEntity = loginRepository.findByEmail(email).orElse(null);
        if (loginEntity != null && loginEntity.getPassword().equals(password)) {
            // Validate the verification code
            return verifyCode(email, verificationCode);
        }
        return false;
    }


    @Override
    public boolean sendVerificationCode(String email) {
        LoginEntity loginEntity = loginRepository.findByEmail(email).orElse(null);
        if (loginEntity != null) {
            String verificationCode = generateVerificationCode();
            loginEntity.setVerificationCode(verificationCode);
            loginEntity.setVerificationCodeExpiry(LocalDateTime.now().plusMinutes(10));
            loginRepository.save(loginEntity);

            try {
                emailService.sendVerificationCode(email, verificationCode);
                return true;
            } catch (MailAuthenticationException e) {
                // Handle authentication failure
                System.out.println("Authentication failed: " + e.getMessage());
                return false;
            } catch (MailSendException e) {
                // Handle email sending failure
                System.out.println("Failed to send email: " + e.getMessage());
                return false;
            }
        }
        return false;
    }


    @Override
    public boolean verifyCode(String email, String verificationCode) {
        LoginEntity loginEntity = loginRepository.findByEmail(email).orElse(null);
        if (loginEntity != null && loginEntity.getVerificationCode() != null) {
            // Check if the verification code matches and if it's still valid (not expired)
            return loginEntity.getVerificationCode().equals(verificationCode) &&
                    loginEntity.getVerificationCodeExpiry().isAfter(LocalDateTime.now());
        }
        return false;
    }

    // Helper method to generate a random verification code
    private String generateVerificationCode() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(999999));
    }
    @Override
    public boolean register(String email, String password, String name) {
        if (loginRepository.findByEmail(email).isPresent()) {
            return false; // Email already exists
        }
        LoginEntity newUser = new LoginEntity(email, password, name);
        loginRepository.save(newUser);
        return true;
    }
}

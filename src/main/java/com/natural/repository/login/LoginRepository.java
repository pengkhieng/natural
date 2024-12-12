package com.natural.repository.login;

import com.natural.entity.login.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<LoginEntity, String> {
    Optional<LoginEntity> findByEmail(String email);
}

package com.example.appjamback.domain.user.domain.repository;

import com.example.appjamback.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User>findByAccountId(String accountId);

    boolean existsByAccountId(String accountId);
}

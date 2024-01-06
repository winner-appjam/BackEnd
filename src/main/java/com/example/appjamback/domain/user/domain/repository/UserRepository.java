package com.example.appjamback.domain.user.domain.repository;

import com.example.appjamback.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByAccountId(String accountId);
}

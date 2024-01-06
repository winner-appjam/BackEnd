package com.example.appjamback.domain.user.service;

import com.example.appjamback.domain.user.domain.User;
import com.example.appjamback.domain.user.domain.repository.UserRepository;
import com.example.appjamback.domain.user.exception.AccountExistsException;
import com.example.appjamback.domain.user.exception.PasswordMissMatchException;
import com.example.appjamback.domain.user.presentation.dto.request.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserSignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignupRequest request) {
        if(userRepository.existsByAccountId(request.getAccountId())){
            throw AccountExistsException.EXCEPTION;
        }
        if(!request.getPassword().equals(request.getValidPassword())) {
            throw PasswordMissMatchException.EXCEPTION;
        }
        userRepository.save(
                User.builder()
                        .accountId(request.getAccountId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .name(request.getName())
                        .build()
        );
    }
}

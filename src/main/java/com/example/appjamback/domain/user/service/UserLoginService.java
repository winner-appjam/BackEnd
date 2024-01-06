package com.example.appjamback.domain.user.service;

import com.example.appjamback.domain.user.domain.User;
import com.example.appjamback.domain.user.exception.PasswordMissMatchException;
import com.example.appjamback.domain.user.facade.UserFacade;
import com.example.appjamback.domain.user.presentation.dto.request.LoginRequest;
import com.example.appjamback.global.security.dto.TokenResponse;
import com.example.appjamback.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserLoginService {
    private final UserFacade userFacade;
    private final JwtTokenProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public TokenResponse execute(LoginRequest request) {

        User user = userFacade.getUserByAccountId(request.getAccountId());

        if (!passwordEncoder.matches(user.getPassword(),request.getPassword())) {
            throw PasswordMissMatchException.EXCEPTION;
        }
        return jwtProvider.getToken(user.getAccountId());
    }
}
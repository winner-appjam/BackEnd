package com.example.appjamback.domain.user.presentation.dto.request;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String accountId;
    private String password;
}
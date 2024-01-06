package com.example.appjamback.domain.user.presentation.dto.request;

import lombok.Getter;

@Getter
public class SignupRequest {
    private String accountId;
    private String password;
    private String email;
    private String name;
}

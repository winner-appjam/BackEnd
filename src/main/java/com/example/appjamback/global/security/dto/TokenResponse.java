package com.example.appjamback.global.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TokenResponse {
    private final String accessToken;
    private final Long expiredAt;
}

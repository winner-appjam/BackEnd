package com.example.appjamback.global.security.jwt;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Base64;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "spring.jwt")
public class JwtProperties {

    private final String secretKey;
    private final Long accessExp;

    public JwtProperties(String secretKey, Long accessExp) {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.accessExp = accessExp;
    }
}

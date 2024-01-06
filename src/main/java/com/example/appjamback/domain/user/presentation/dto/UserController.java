package com.example.appjamback.domain.user.presentation.dto;

import com.example.appjamback.domain.user.presentation.dto.request.LoginRequest;
import com.example.appjamback.domain.user.presentation.dto.request.SignupRequest;
import com.example.appjamback.domain.user.service.UserLoginService;
import com.example.appjamback.domain.user.service.UserSignupService;
import com.example.appjamback.global.security.dto.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User", description = "User API 입니다.")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserSignupService userSignupService;
    private final UserLoginService userLoginService;

    @Operation(summary = "회원가입")
    @PostMapping
    public void signup(@RequestBody SignupRequest signupRequest) {
        userSignupService.execute(signupRequest);
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest loginRequest) {
        return userLoginService.execute(loginRequest);
    }
}

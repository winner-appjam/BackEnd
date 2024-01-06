package com.example.appjamback.domain.user.presentation.dto;

import com.example.appjamback.domain.user.presentation.dto.request.SignupRequest;
import com.example.appjamback.domain.user.service.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserSignupService userSignupService;

    @PostMapping
    public void signup(@RequestBody SignupRequest signupRequest) {
        userSignupService.execute(signupRequest);
    }
}

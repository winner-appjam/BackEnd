package com.example.instargram.domain.user.presentation

import com.example.instargram.domain.user.presentation.dto.request.LoginRequest
import com.example.instargram.domain.user.presentation.dto.request.SignupRequest
import com.example.instargram.domain.user.service.UserLoginService
import com.example.instargram.domain.user.service.UserSignupService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userSignupService: UserSignupService,
    private val userLoginService: UserLoginService
) {

    @PostMapping
    fun signup(signupRequest: SignupRequest) =
        userSignupService.execute(signupRequest)

    @PostMapping("/login")
    fun login(loginRequest: LoginRequest) =
        userLoginService.execute(loginRequest)
}

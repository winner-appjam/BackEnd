package com.example.instargram.domain.user.presentation

import com.example.instargram.domain.user.presentation.dto.request.CreateMemoRequest
import com.example.instargram.domain.user.presentation.dto.request.LoginRequest
import com.example.instargram.domain.user.presentation.dto.request.SignupRequest
import com.example.instargram.domain.user.presentation.dto.response.QueryMemoResponse
import com.example.instargram.domain.user.service.CreateMomoService
import com.example.instargram.domain.user.service.MyMemoQueryService
import com.example.instargram.domain.user.service.UserLoginService
import com.example.instargram.domain.user.service.UserSignupService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/user")
class UserController(
    private val userSignupService: UserSignupService,
    private val userLoginService: UserLoginService,
    private val myMemoQueryService: MyMemoQueryService,
    private val createMomoService: CreateMomoService
) {

    @PostMapping
    fun signup(@RequestBody signupRequest: SignupRequest) =
        userSignupService.execute(signupRequest)

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest) =
        userLoginService.execute(loginRequest)

    @PostMapping("/memo")
    fun createMemo(@RequestBody createMemoRequest: CreateMemoRequest) =
        createMomoService.execute(createMemoRequest)

    @GetMapping("/memo")
    fun getMemo(): QueryMemoResponse = myMemoQueryService.execute()
}

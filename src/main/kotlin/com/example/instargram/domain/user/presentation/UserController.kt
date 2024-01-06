package com.example.instargram.domain.user.presentation

import com.example.instargram.domain.user.presentation.dto.request.CreateMemoRequest
import com.example.instargram.domain.user.presentation.dto.request.LoginRequest
import com.example.instargram.domain.user.presentation.dto.request.ModifyRequest
import com.example.instargram.domain.user.presentation.dto.request.SignupRequest
import com.example.instargram.domain.user.presentation.dto.response.QueryMemoResponse
import com.example.instargram.domain.user.service.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
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
    private val modifyInfoService: ModifyInfoService,
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

    @PatchMapping("/modify")
    fun modifyInfo(@RequestBody modifyRequest: ModifyRequest) =
        modifyInfoService.execute(modifyRequest)

    @GetMapping("/memo")
    fun getMemo(): QueryMemoResponse = myMemoQueryService.execute()
}

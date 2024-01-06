package com.example.instargram.domain.user.presentation

import com.example.instargram.domain.user.presentation.dto.request.*
import com.example.instargram.domain.user.presentation.dto.response.MyInfoResponse
import com.example.instargram.domain.user.presentation.dto.response.QueryMemoResponse
import com.example.instargram.domain.user.service.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/user")
class UserController(
    private val userSignupService: UserSignupService,
    private val userLoginService: UserLoginService,
    private val myMemoQueryService: MyMemoQueryService,
    private val modifyInfoService: ModifyInfoService,
    private val createSchoolService: CreateSchoolService,
    private val userProfileUploadService: UserProfileUploadService,
    private val createMomoService: CreateMomoService,
    private val myInfoService: MyInfoService
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

    @PatchMapping("/school")
    fun createSchool(@RequestBody addSchoolRequest: AddSchoolRequest) =
        createSchoolService.execute(addSchoolRequest)

    @PatchMapping("/image")
    fun upload(@RequestPart(name = "file", required = false)file: MultipartFile) =
        userProfileUploadService.execute(file)

    @GetMapping("/memo")
    fun getMemo(): QueryMemoResponse = myMemoQueryService.execute()

    @GetMapping("/info")
    fun info(): MyInfoResponse =
        myInfoService.execute()
}

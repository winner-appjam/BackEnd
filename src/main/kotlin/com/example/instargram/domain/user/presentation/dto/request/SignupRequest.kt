package com.example.instargram.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

data class SignupRequest (
    val password: String,
    val validPassword: String,
    val accountId: String,
    val name: String,
)

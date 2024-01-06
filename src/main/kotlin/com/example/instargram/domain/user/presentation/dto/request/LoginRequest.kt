package com.example.instargram.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank

data class LoginRequest (
    @NotBlank
    val info: String,

    @NotBlank
    val password: String,
)

package com.example.instargram.domain.user.presentation.dto.request


data class LoginRequest (
    val accountId: String,

    val password: String,
)

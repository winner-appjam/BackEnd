package com.example.instargram.domain.user.presentation.dto.request

data class ModifyRequest (
    val accountId: String,
    val newPassword: String,
    val validPassword: String,
    val name: String,
    val year: Int,
    val month: Int,
    val day: Int
)
package com.example.instargram.global.error.exception

import java.time.LocalDateTime

data class ErrorResponse (
    val status: Int,
    val massage: String,
    val timestamp: LocalDateTime
)

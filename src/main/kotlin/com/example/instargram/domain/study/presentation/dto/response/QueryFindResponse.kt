package com.example.instargram.domain.study.presentation.dto.response

import com.example.instargram.domain.user.domain.User

data class QueryFindResponse (
    val content: String,
    val title: String,
    val accountId: String
)
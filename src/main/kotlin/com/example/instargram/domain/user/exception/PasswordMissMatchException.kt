package com.example.instargram.domain.user.exception

import com.example.instargram.global.error.exception.BusinessException
import com.example.instargram.global.error.exception.ErrorCode

object PasswordMissMatchException: BusinessException(
    ErrorCode.PASSWORD_MISS_MATCH
)

package com.example.instargram.domain.user.exception

import com.example.instargram.global.error.exception.BusinessException
import com.example.instargram.global.error.exception.ErrorCode

object EmailCodeMissMatchException: BusinessException (
    ErrorCode.EMAIL_CODE_MISS_MATCH
)

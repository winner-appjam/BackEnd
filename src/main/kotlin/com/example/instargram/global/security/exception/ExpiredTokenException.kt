package com.example.instargram.global.security.exception

import com.example.instargram.global.error.exception.BusinessException
import com.example.instargram.global.error.exception.ErrorCode

object ExpiredTokenException : BusinessException (
    ErrorCode.EXPIRED_TOKEN
)

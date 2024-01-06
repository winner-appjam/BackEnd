package com.example.instargram.global.security.exception

import com.example.instargram.global.error.exception.BusinessException
import com.example.instargram.global.error.exception.ErrorCode

object InternalServerErrorException : BusinessException(
    ErrorCode.INTERNAL_SERVER_ERROR
)

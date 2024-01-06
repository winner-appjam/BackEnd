package com.example.instargram.domain.user.exception

import com.example.instargram.global.error.exception.BusinessException
import com.example.instargram.global.error.exception.ErrorCode

object UserAlreadyException: BusinessException (
    ErrorCode.ACCOUNTID_ALREADY_EXISTS
)

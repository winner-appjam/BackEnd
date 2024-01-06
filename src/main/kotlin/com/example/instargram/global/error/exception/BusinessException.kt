package com.example.instargram.global.error.exception

abstract class BusinessException (
    val errorCode : ErrorCode
) : RuntimeException()

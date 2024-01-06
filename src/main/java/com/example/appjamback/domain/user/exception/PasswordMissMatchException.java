package com.example.appjamback.domain.user.exception;

import com.example.appjamback.global.error.exception.BusinessException;
import com.example.appjamback.global.error.exception.ErrorCode;

public class PasswordMissMatchException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new PasswordMissMatchException();

    private PasswordMissMatchException() {super(ErrorCode.PASSWORD_MISS_MATCH);}
}
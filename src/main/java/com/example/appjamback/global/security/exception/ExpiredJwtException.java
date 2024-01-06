package com.example.appjamback.global.security.exception;

import com.example.appjamback.global.error.exception.BusinessException;
import com.example.appjamback.global.error.exception.ErrorCode;

public class ExpiredJwtException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}

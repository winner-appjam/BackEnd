package com.example.appjamback.domain.user.exception;

import com.example.appjamback.global.error.exception.BusinessException;
import com.example.appjamback.global.error.exception.ErrorCode;

public class UserNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {super(ErrorCode.USER_NOT_FOUND);}
}

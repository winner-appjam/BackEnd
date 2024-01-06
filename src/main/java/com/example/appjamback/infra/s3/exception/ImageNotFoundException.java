package com.example.appjamback.infra.s3.exception;

import com.example.appjamback.global.error.exception.BusinessException;
import com.example.appjamback.global.error.exception.ErrorCode;

public class ImageNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new ImageNotFoundException();

    private ImageNotFoundException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}

package com.musinsa.goods.exception;

import com.musinsa.goods.config.constants.ExceptionCode;
import lombok.Data;

/**
 * 비즈니스 로직 Exception 클래스
 */
@Data
public class BusinessLogicException extends RuntimeException {

    private final String errorCode;
    private final String errorMessage;

    public BusinessLogicException(ExceptionCode exceptionCode) {
        this.errorCode = exceptionCode.getErrorCode();
        this.errorMessage = exceptionCode.getErrorMessage();
    }

}

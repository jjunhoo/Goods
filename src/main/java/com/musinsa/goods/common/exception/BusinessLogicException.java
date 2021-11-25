package com.musinsa.goods.common.exception;

import com.musinsa.goods.common.constants.ExceptionCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 비즈니스 로직 Exception 클래스
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessLogicException extends RuntimeException {

    private String errorCode;
    private String errorMessage;
    private String message = "";

    public BusinessLogicException(ExceptionCode exceptionCode) {
        this.errorCode = exceptionCode.getErrorCode();
        this.errorMessage = exceptionCode.getErrorMessage();
    }

    public BusinessLogicException(ExceptionCode exceptionCode, String message) {
        this.errorCode = exceptionCode.getErrorCode();
        this.errorMessage = exceptionCode.getErrorMessage();
        this.message = message;
    }
}

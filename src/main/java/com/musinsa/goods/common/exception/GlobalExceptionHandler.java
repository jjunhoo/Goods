package com.musinsa.goods.common.exception;

import com.musinsa.goods.common.util.ErrorResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * BusinessLogicException
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessLogicException.class)
    protected ResponseEntity<ErrorResponse> businessLogicException(final BusinessLogicException e) {
        ErrorResponse errorResponse = new ErrorResponse(GlobalExceptionHandler.replaceErrorMessage(e.getErrorMessage(), e.getMessage()), e.getErrorCode());

        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * 에러 메시지 문자열 변환
     * @param errorMessage
     * @param message
     * @return
     */
    private static String replaceErrorMessage(String errorMessage, String message) {
        return StringUtils.isBlank(message) ? errorMessage : errorMessage.replace("%s", message);
    }
}

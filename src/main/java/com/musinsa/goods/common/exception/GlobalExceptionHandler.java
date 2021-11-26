package com.musinsa.goods.common.exception;

import com.musinsa.goods.common.constants.ExceptionCode;
import com.musinsa.goods.common.util.ErrorResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * BusinessLogicException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessLogicException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessLogicException(final BusinessLogicException e) {
        ErrorResponse errorResponse = new ErrorResponse(GlobalExceptionHandler.replaceErrorMessage(e.getErrorMessage(), e.getMessage()), e.getErrorCode());

        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * NumberFormatException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NumberFormatException.class)
    protected ResponseEntity<ErrorResponse> handleNumberFormatException(final NumberFormatException e) {
        ErrorResponse errorResponse = new ErrorResponse(ExceptionCode.ERROR_CODE_1005.getErrorMessage(), ExceptionCode.ERROR_CODE_1005.getErrorCode());

        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * NoHandlerFoundException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    protected ResponseEntity<ErrorResponse> handleNoHandlerFoundException(final NoHandlerFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(ExceptionCode.SYS_ERROR_CODE_9001.getErrorMessage(), ExceptionCode.SYS_ERROR_CODE_9001.getErrorCode());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * HttpRequestMethodNotSupportedException
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        ErrorResponse errorResponse = new ErrorResponse(ExceptionCode.SYS_ERROR_CODE_9002.getErrorMessage(), ExceptionCode.SYS_ERROR_CODE_9002.getErrorCode());

        return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }

    /*@ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<ErrorResponse> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        ErrorResponse errorResponse = new ErrorResponse(ExceptionCode.ERROR_CODE_1006.getErrorMessage(), ExceptionCode.ERROR_CODE_1006.getErrorCode());

        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }*/

    // TODO : 400 - Bad Request

    /**
     * 에러 메시지 문자열 변환
     *
     * @param errorMessage
     * @param message
     * @return
     */
    private static String replaceErrorMessage(String errorMessage, String message) {
        return StringUtils.isBlank(message) ? errorMessage : errorMessage.replace("%s", message);
    }
}

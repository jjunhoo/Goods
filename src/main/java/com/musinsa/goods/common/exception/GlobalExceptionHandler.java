package com.musinsa.goods.common.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.musinsa.goods.common.constants.ExceptionCode;
import com.musinsa.goods.common.util.ErrorResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
        ErrorResponse errorResponse = new ErrorResponse(ExceptionCode.ERROR_CODE_2001.getErrorMessage(), ExceptionCode.ERROR_CODE_2001.getErrorCode());

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

    /**
     * MethodArgumentNotValidException
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder errorMessage = new StringBuilder();
        FieldError fieldError = e.getBindingResult().getFieldError();

        ErrorResponse errorResponse;

        String errorCode;
        String codeType;
        String errorDefaultMessage;
        Object[] errorArguments;

        if (fieldError != null) {
            codeType = fieldError.getCode();
            errorDefaultMessage = fieldError.getDefaultMessage();
            errorArguments = fieldError.getArguments();

            Object errorArgument = errorArguments.length > 1 ? errorArguments[1] : "";

            switch (codeType) {
                case "NotEmpty":
                    errorCode = ExceptionCode.ERROR_CODE_2003.getErrorCode();
                    errorMessage.append("(").append(errorDefaultMessage).append(") ").append(ExceptionCode.ERROR_CODE_2003.getErrorMessage());
                    errorResponse = new ErrorResponse(errorMessage.toString(), errorCode);
                    break;
                case "Size":
                    errorCode = ExceptionCode.ERROR_CODE_2004.getErrorCode();
                    errorMessage.append("(").append(errorDefaultMessage).append(") ");
                    errorMessage.append(errorArgument).append(ExceptionCode.ERROR_CODE_2004.getErrorMessage());
                    errorResponse = new ErrorResponse(errorMessage.toString(), errorCode);
                    break;
                default:
                    errorCode = ExceptionCode.ERROR_CODE_2002.getErrorCode();
                    errorMessage.append("(").append(errorDefaultMessage).append(") ").append(ExceptionCode.ERROR_CODE_2002.getErrorMessage());
                    errorResponse = new ErrorResponse(errorMessage.toString(), errorCode);
            }
        } else {
            errorResponse = new ErrorResponse(ExceptionCode.SYS_ERROR_CODE_9000.getErrorMessage(), ExceptionCode.SYS_ERROR_CODE_9000.getErrorCode());
        }

        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * HttpMessageNotReadableException
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        ErrorResponse errorResponse;

        if (e.getCause() instanceof JsonMappingException) {
            JsonMappingException ex = (JsonMappingException) e.getCause();
            errorResponse = new ErrorResponse(GlobalExceptionHandler.getDetailErrorMsg(ex.getPath().get(0).getFieldName(), ExceptionCode.ERROR_CODE_2001.getErrorMessage()), ExceptionCode.ERROR_CODE_2001.getErrorCode());
        } else {
            errorResponse = new ErrorResponse(ExceptionCode.ERROR_CODE_2001.getErrorMessage(), ExceptionCode.ERROR_CODE_2001.getErrorCode());
        }

        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

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

    /**
     * 에러 메시지 - 필드명 추가
     * @param keyName
     * @param errorMessage
     * @return
     */
    private static String getDetailErrorMsg(final String keyName, final String errorMessage) {
        return "(" + keyName + ") " + errorMessage;
    }
}

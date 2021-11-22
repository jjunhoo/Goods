package com.musinsa.goods.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessLogicException.class)
    public @ResponseBody String error(BusinessLogicException e) {
        System.out.println("[ ExceptionHandler > BusinessLogicException ] :: " + e.toString());
        return e.toString();
    }

}

package com.musinsa.goods.common.util;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private String errorMessage;
    private String errorCode;

    public ErrorResponse(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public ErrorResponse of(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        return this;
    }
}

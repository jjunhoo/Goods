package com.musinsa.goods.config.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 공통 Exception 처리 클래스
 */
@RequiredArgsConstructor
public enum ExceptionCode {

    ERROR_CODE_1001("1001", "존재하지 않는 상품번호입니다."),
    ERROR_CODE_1002("1002", "존재하지 않는 업체 아이디입니다.")
    ;

    @Getter
    private final String errorCode;
    @Getter
    private final String errorMessage;

    @Override
    public String toString() {
        return errorCode + " : " + errorMessage;
    }
}

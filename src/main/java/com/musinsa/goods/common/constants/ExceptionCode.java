package com.musinsa.goods.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 공통 Exception 처리 클래스
 */
@RequiredArgsConstructor
public enum ExceptionCode {
    SYS_ERROR_CODE_9001("9001", "잘못된 URL을 호출 하였습니다."),
    SYS_ERROR_CODE_9002("9002", "Http Method가 잘못 되었습니다."),

    ERROR_CODE_1001("1001", "존재하지 않는 %s 입니다."),
    ERROR_CODE_1002("1002", "존재하지 않는 상품번호입니다."),
    ERROR_CODE_1003("1003", "존재하지 않는 업체 아이디입니다."),
    ERROR_CODE_1004("1004", "상품번호는 %s만 입력 가능합니다."),
    ERROR_CODE_1005("1005", "파라미터 타입 오류입니다."),
    ERROR_CODE_1006("1006", "필수값을 입력해주세요")
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

package com.musinsa.goods.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 공통 Exception 처리 클래스
 */
@RequiredArgsConstructor
public enum ExceptionCode {
    SYS_ERROR_CODE_9000("9000", "시스템 에러 : 관리자에게 문의해 주세요."),
    SYS_ERROR_CODE_9001("9001", "잘못된 URL을 호출 하였습니다."),
    SYS_ERROR_CODE_9002("9002", "Http Method가 잘못 되었습니다."),

    ERROR_CODE_1001("1001", "존재하지 않는 %s 입니다."),

    ERROR_CODE_2001("2001", "파라미터 타입 오류입니다."),
    ERROR_CODE_2002("2002", "파라미터 유효성 검사 오류입니다."),
    ERROR_CODE_2003("2003", "필수값을 입력해주세요"),
    ERROR_CODE_2004("2004", "자 이하로 입력해주세요.")
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

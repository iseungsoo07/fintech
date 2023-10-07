package com.zerobase.product.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(HttpStatus.BAD_REQUEST, "내부 서버 오류"),
    NOT_FOUND_CODE(HttpStatus.BAD_REQUEST, "해당 코드를 찾을 수 없습니다."),
    NOT_FOUND_PRODUCT(HttpStatus.BAD_REQUEST, "해당 상품이 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String detail;
}

package com.zerobase.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND_PRODUCT("해당 상품이 존재하지 않습니다.");

    private final String description;
}

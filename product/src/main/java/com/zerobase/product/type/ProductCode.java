package com.zerobase.product.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductCode {
    NONE("000"), PRODUCT_ONE("001"), PRODUCT_TWO("002");

    private final String code;

}

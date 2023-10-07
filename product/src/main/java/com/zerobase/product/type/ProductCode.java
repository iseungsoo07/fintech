package com.zerobase.product.type;

import com.zerobase.product.exception.CustomException;
import com.zerobase.product.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductCode {
    NONE("000"), PRODUCT_ONE("001"), PRODUCT_TWO("002");

    private final String code;

    public static ProductCode getProductCode(String code) {
        for (ProductCode productCode : values()) {
            if (productCode.getCode().equals(code)) {
                return productCode;
            }
        }

        throw new CustomException(ErrorCode.NOT_FOUND_CODE);
    }

}

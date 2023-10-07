package com.zerobase.product.type;

import com.zerobase.product.exception.CustomException;
import com.zerobase.product.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrganizationCode {
    NONE("00000"), ORGANIZATION_ONE("00001"), ORGANIZATION_TWO("00002");

    private final String code;

    public static OrganizationCode getOrganizationCode(String code) {
        for (OrganizationCode organizationCode : values()) {
            if (organizationCode.getCode().equals(code)) {
                return organizationCode;
            }
        }

        throw new CustomException(ErrorCode.NOT_FOUND_CODE);
    }
}

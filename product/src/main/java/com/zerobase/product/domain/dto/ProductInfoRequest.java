package com.zerobase.product.domain.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductInfoRequest {

    private String organizationCode;
    private String productCode;
    private Double productMaximumInterest;
    private Double productMinimumInterest;
    private String productName;
}

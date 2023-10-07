package com.zerobase.product.service;

import com.zerobase.product.domain.dto.ProductInfoRequest;
import com.zerobase.product.domain.dto.ProductInfoResponse;
import com.zerobase.product.domain.dto.Response;
import com.zerobase.product.type.OrganizationCode;

public interface ProductInfoService {
    ProductInfoResponse searchProductInfo(OrganizationCode organizationCode);

    Response getProductInfo(ProductInfoRequest productInfoRequest);
}

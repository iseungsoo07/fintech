package com.zerobase.product.controller;

import com.zerobase.product.domain.dto.ProductInfoRequest;
import com.zerobase.product.domain.dto.ProductInfoResponse;
import com.zerobase.product.domain.dto.Response;
import com.zerobase.product.type.OrganizationCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductInformationController {
    ResponseEntity<ProductInfoResponse> searchProductInfo(@PathVariable OrganizationCode organizationCode);

    ResponseEntity<Response> getProductInfo(@RequestBody ProductInfoRequest productInfoRequest);
}

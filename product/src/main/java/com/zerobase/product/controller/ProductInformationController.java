package com.zerobase.product.controller;

import com.zerobase.product.domain.dto.ProductInfoRequest;
import com.zerobase.product.domain.dto.ProductInfoResponse;
import com.zerobase.product.service.ProductInfoService;
import com.zerobase.product.type.OrganizationCode;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fintech/v1/product")
public class ProductInformationController {

    private final ProductInfoService productInfoService;

    @ApiOperation("상품 정보 조회 API")
    @GetMapping("/{organizationCode}")
    public ResponseEntity<ProductInfoResponse> searchProductInfo(@PathVariable OrganizationCode organizationCode) {
        ProductInfoResponse productInfoResponse = productInfoService.searchProductInfo(organizationCode);

        return ResponseEntity.ok(productInfoResponse);
    }

    @ApiOperation("상품 정보 수신 API")
    @PostMapping("/information")
    public ResponseEntity<ProductInfoResponse> getProductInfo(@RequestBody ProductInfoRequest productInfoRequest) {

        if (productInfoService.getProductInfo(productInfoRequest)) {
            return ResponseEntity.ok(ProductInfoResponse.builder()
                    .responseCode("00")
                    .responseMessage("success")
                    .build());
        }

        return ResponseEntity.badRequest().build();
    }
}

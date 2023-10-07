package com.zerobase.product.controller;

import com.zerobase.product.domain.dto.ProductInfoRequest;
import com.zerobase.product.domain.dto.ProductInfoResponse;
import com.zerobase.product.domain.dto.Response;
import com.zerobase.product.service.ProductInfoService;
import com.zerobase.product.type.OrganizationCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fintech/v1/product")
@Slf4j
@Api(description = "상품 정보 API")
public class ProductInformationControllerImpl implements ProductInformationController {

    private final ProductInfoService productInfoService;

    @ApiOperation(value = "상품 정보 조회 API", notes = "상품 정보를 조회하는 API")
    @GetMapping("/{organizationCode}")
    public ResponseEntity<ProductInfoResponse> searchProductInfo(@ApiParam(value = "기관 코드")
                                                                 @PathVariable OrganizationCode organizationCode) {
        ProductInfoResponse productInfoResponse = productInfoService.searchProductInfo(organizationCode);

        return ResponseEntity.ok(productInfoResponse);
    }

    @ApiOperation(value = "상품 정보 수신 API", notes = "금융사로부터 상품 정보를 받는 API")
    @PostMapping("/information")
    public ResponseEntity<Response> getProductInfo(@RequestBody ProductInfoRequest productInfoRequest) {

        Response response = productInfoService.getProductInfo(productInfoRequest);

        return ResponseEntity.ok(response);
    }
}

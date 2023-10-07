package com.zerobase.product.service;

import com.zerobase.product.domain.dto.ProductInfoRequest;
import com.zerobase.product.domain.dto.ProductInfoResponse;
import com.zerobase.product.domain.model.ProductInfo;
import com.zerobase.product.repository.ProductInfoRepository;
import com.zerobase.product.type.OrganizationCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductInfoService {

    private final ProductInfoRepository productInfoRepository;

    public ProductInfoResponse searchProductInfo(OrganizationCode organizationCode) {
        List<ProductInfo> productInfoList = productInfoRepository.findAllByOrganizationCode(organizationCode);

        List<ProductInfoRequest> productInfoRequestList = productInfoList.stream()
                .map(productInfo -> ProductInfoRequest.builder()
                        .productName(productInfo.getProductName())
                        .productCode(productInfo.getProductCode().getCode())
                        .productMinimumInterest(productInfo.getProductMinimumInterest())
                        .productMaximumInterest(productInfo.getProductMaximumInterest())
                        .organizationCode(productInfo.getOrganizationCode().getCode())
                        .build())
                .collect(Collectors.toList());

        return ProductInfoResponse.builder()
                .data(productInfoRequestList)
                .responseCode("00")
                .responseMessage("success")
                .build();
    }

    public boolean getProductInfo(ProductInfoRequest productDto) {
        // return productInfoRepository.existsByProductCode();
        return false;
    }

}

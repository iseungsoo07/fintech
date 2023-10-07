package com.zerobase.product.service;

import com.zerobase.product.domain.dto.ProductInfoRequest;
import com.zerobase.product.domain.dto.ProductInfoResponse;
import com.zerobase.product.domain.dto.Response;
import com.zerobase.product.domain.model.ProductInfo;
import com.zerobase.product.exception.CustomException;
import com.zerobase.product.exception.ErrorCode;
import com.zerobase.product.repository.ProductInfoRepository;
import com.zerobase.product.type.OrganizationCode;
import com.zerobase.product.type.ProductCode;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductInfoServiceImpl implements ProductInfoService {

    private final ProductInfoRepository productInfoRepository;

    private final String CACHE_KEY = "product";

    @Override
    @Cacheable(value = CACHE_KEY, key = "#organizationCode")
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

    @Override
    @CacheEvict(value = CACHE_KEY, allEntries = true)
    public Response getProductInfo(ProductInfoRequest productInfoRequest) {
        ProductCode productCode = ProductCode.getProductCode(productInfoRequest.getProductCode());
        OrganizationCode organizationCode = OrganizationCode.getOrganizationCode(productInfoRequest.getOrganizationCode());

        ProductInfo productInfo = productInfoRepository.findByProductCode(productCode)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_PRODUCT));

        productInfo.setProductName(productInfoRequest.getProductName());
        productInfo.setProductCode(productCode);
        productInfo.setProductMaximumInterest(productInfoRequest.getProductMaximumInterest());
        productInfo.setProductMinimumInterest(productInfoRequest.getProductMinimumInterest());
        productInfo.setOrganizationCode(organizationCode);

        return Response.builder()
                .responseCode("00")
                .responseMessage("success")
                .build();
    }

}

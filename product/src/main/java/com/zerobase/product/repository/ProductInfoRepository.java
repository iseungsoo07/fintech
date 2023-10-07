package com.zerobase.product.repository;

import com.zerobase.product.domain.model.ProductInfo;
import com.zerobase.product.type.OrganizationCode;
import com.zerobase.product.type.ProductCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {
    boolean existsByProductCode(ProductCode productCode);

    List<ProductInfo> findAllByOrganizationCode(OrganizationCode organizationCode);
}

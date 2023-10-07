package com.zerobase.product.domain.model;

import com.zerobase.product.type.OrganizationCode;
import com.zerobase.product.type.ProductCode;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class ProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "org_cd")
    @Enumerated(EnumType.STRING)
    private OrganizationCode organizationCode;

    @Column(name = "prod_cd")
    @Enumerated(EnumType.STRING)
    private ProductCode productCode;

    @Column(name = "prod_nm")
    private String productName;

    @Column(name = "prod_max_intr")
    private Double productMaximumInterest;

    @Column(name = "prod_min_intr")
    private Double productMinimumInterest;

}

package com.zerobase.user.domain.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usr_key")
    private String userKey;

    @Column(name = "usr_reg_num")
    private String userRegistrationNumber;

    @Column(name = "usr_nm")
    private String userName;

    @Column(name = "usr_icm_amt")
    private Long userIncomeAmount;
}

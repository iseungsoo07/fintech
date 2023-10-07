package com.zerobase.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoRequest {
    private String userName;
    private Long userIncomeAmount;
    private String userRegistrationNumber;
}

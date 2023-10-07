package com.zerobase.user.domain.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class UserInfoGetResponse extends Response {
    private UserKeyResponse data;
}

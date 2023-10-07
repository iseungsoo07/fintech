package com.zerobase.user.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class UserFindResponse {
    @JsonProperty
    private String userKey;
    @JsonProperty
    private String userRegistrationNumber;
}

package com.zerobase.user.service;

import com.zerobase.user.domain.dto.UserInfoGetResponse;
import com.zerobase.user.domain.dto.UserInfoRequest;
import com.zerobase.user.domain.dto.UserInfoSearchResponse;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserInfoService {

    UserInfoGetResponse getUserInfo(@PathVariable UserInfoRequest userInfoRequest);

    UserInfoSearchResponse searchUserInfo(String userKey);

}

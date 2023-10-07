package com.zerobase.user.controller;

import com.zerobase.user.domain.dto.UserInfoRequest;
import com.zerobase.user.domain.dto.UserInfoGetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserInformationController {
    ResponseEntity<UserInfoGetResponse> getUserInfo(@RequestBody UserInfoRequest userInfoRequest);

    ResponseEntity<?> searchUserInfo(@PathVariable String userKey);
}

package com.zerobase.user.controller;

import com.zerobase.user.domain.dto.UserInfoGetResponse;
import com.zerobase.user.domain.dto.UserInfoRequest;
import com.zerobase.user.domain.dto.UserInfoSearchResponse;
import com.zerobase.user.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("fintech/v1/user")
public class UserInformationControllerImpl implements UserInformationController {

    private final UserInfoService userInfoService;

    @Override
    @ApiOperation(value = "유저 정보 조회 API", notes = "유저 정보를 조회하는 API")
    @GetMapping("/private-info/{userKey}")
    public ResponseEntity<UserInfoSearchResponse> searchUserInfo(@PathVariable String userKey) {
        UserInfoSearchResponse userInfoSearchResponse = userInfoService.searchUserInfo(userKey);

        return ResponseEntity.ok(userInfoSearchResponse);
    }

    @Override
    @ApiOperation(value = "유저 정보 수신 API", notes = "유저 정보를 받는 API")
    @PostMapping("/information")
    public ResponseEntity<UserInfoGetResponse> getUserInfo(@RequestBody UserInfoRequest userInfoRequest) {
        UserInfoGetResponse userInfoGetResponse = userInfoService.getUserInfo(userInfoRequest);

        return ResponseEntity.ok(userInfoGetResponse);
    }

}

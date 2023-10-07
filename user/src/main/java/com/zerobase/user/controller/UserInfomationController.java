package com.zerobase.user.controller;

import com.zerobase.user.domain.dto.UserInfoRequest;
import com.zerobase.user.domain.dto.UserInfoResponse;
import com.zerobase.user.domain.model.UserInfo;
import com.zerobase.user.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("fintech/v1/user")
public class UserInfomationController {

    private final UserInfoService userInfoService;

    @ApiOperation("유저 정보 수신 API")
    @PostMapping("/information")
    public ResponseEntity<UserInfoResponse> getUserInfo(@RequestBody UserInfoRequest userInfoRequest) {

        UserInfo userInfo = userInfoService.getUserInfo(userInfoRequest);

        String userKey = userInfo.getUserKey();

        // return ResponseEntity.ok(UserInfoResponse.builder()
        //         .data(userInfo.getUserKey())
        //         .responseCode("00")
        //         .reponseMessage("success")
        //         .build());

        return null;
    }

    @ApiOperation("유저 정보 조회 API")
    @GetMapping("/private-info/{userKey}")
    public ResponseEntity<?> searchUserInfo(@PathVariable String userKey) {
        return null;
    }
}

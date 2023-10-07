package com.zerobase.user.service;

import com.zerobase.user.domain.dto.UserInfoRequest;
import com.zerobase.user.domain.model.UserInfo;
import com.zerobase.user.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfo getUserInfo(UserInfoRequest userInfoRequest) {
        return userInfoRepository.findByUserRegistrationNumber(userInfoRequest.getUserRegistrationNumber());
    }
}

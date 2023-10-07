package com.zerobase.user.service;

import com.zerobase.user.domain.dto.*;
import com.zerobase.user.domain.model.UserInfo;
import com.zerobase.user.exception.CustomException;
import com.zerobase.user.exception.ErrorCode;
import com.zerobase.user.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    @Override
    public UserInfoSearchResponse searchUserInfo(String userKey) {
        UserInfo userInfo = userInfoRepository.findByUserKey(userKey)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER));

        UserFindResponse userFindResponse = UserFindResponse.builder()
                .userKey(userKey)
                .userRegistrationNumber(userInfo.getUserRegistrationNumber())
                .build();

        return UserInfoSearchResponse.builder()
                .data(userFindResponse)
                .responseCode("00")
                .responseMessage("success")
                .build();
    }

    @Override
    public UserInfoGetResponse getUserInfo(UserInfoRequest userInfoRequest) {

        String randomKey = generateRandomKey(32);

        UserInfo userInfo = UserInfo.builder()
                .userName(userInfoRequest.getUserName())
                .userKey(randomKey)
                .userIncomeAmount(userInfoRequest.getUserIncomeAmount())
                .userRegistrationNumber(userInfoRequest.getUserRegistrationNumber())
                .build();

        UserInfo savedUserInfo = userInfoRepository.save(userInfo);

        return UserInfoGetResponse.builder()
                .data(UserKeyResponse.builder().userKey(savedUserInfo.getUserKey()).build())
                .responseMessage("success")
                .responseCode("00")
                .build();


    }

    private static String generateRandomKey(int length) {
        StringBuilder randomKeyBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomType = RandomUtils.nextInt(0, 2);

            char randomChar;
            if (randomType == 0) {
                randomChar = (char) RandomUtils.nextInt('0', '9' + 1);
            } else {
                randomChar = (char) RandomUtils.nextInt('a', 'z' + 1);
            }

            randomKeyBuilder.append(randomChar);
        }
        return randomKeyBuilder.toString();
    }
}

package com.zerobase.user.repository;

import com.zerobase.user.domain.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByUserRegistrationNumber(String registrationNumber);

    Optional<UserInfo> findByUserKey(String userKey);

}

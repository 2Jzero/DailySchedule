package com.project.service;

import com.project.jpa.UserInfo;
import com.project.jpa.UserJPA;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserInfo userInfo;

    @Autowired
    public UserService(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Transactional
    public int updatePoint(String userId, int point) {

        return userInfo.updatePoint(userId, point);
    }

    public int userPoint(String userId) {

        return userInfo.userPoint(userId);
    }

    // 회원가입 한 회원정보 추가
    public UserJPA sign(UserJPA userJPA) {

        int maxNumber = userInfo.userJPAMaxNumber();
        userJPA.setUserNum(maxNumber + 1);

        return userInfo.save(userJPA);
    }
}

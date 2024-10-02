package com.project.service;

import com.project.jpa.UserInfo;
import com.project.jpa.UserJPA;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    // 회원가입 한 회원정보 추가, 비밀번호 암호화
    public UserJPA sign(UserJPA userJPA) {

        BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
        String encodeUserPassword = encoder.encode(userJPA.getUserPw());
        userJPA.setUserPw(encodeUserPassword);

        int maxNumber = userInfo.userJPAMaxNumber();
        userJPA.setUserNum(maxNumber + 1);

        return userInfo.save(userJPA);
    }
    
    // 로그인 하기 위해 입력된 id, pw 바탕으로 db의 암호화 패스워드와 비교
    public UserJPA login(String userId, String userPw) {

        UserJPA userJPA = userInfo.login(userId);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String dbPassword = userJPA.getUserPw();

        if(encoder.matches(userPw, dbPassword)) {
            return userJPA;
        }

        return null;
    }

}

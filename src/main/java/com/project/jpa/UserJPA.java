package com.project.jpa;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Getter // Builder 이용하여 객체 생성
@Builder // AllArgsConstructor, NoArgsConstructor 같이 이용해야 컴파일 에러 발생 안함
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class UserJPA {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    @Column(name = "user_sq") // 컬럼 정의
    private int userSq;

    // 사용자 번호
    @Column(name = "user_no")
    private int userNum;

    // 사용자 id
    @Column(length = 20, name = "user_id")
    private String userId;

    // 사용자 pw
    @Column(length = 100, name = "user_pw")
    private String userPw;

    // 유저 포인트
    @Column(name = "user_point", columnDefinition = "int default 0") // columnDefinition = 기본값
    private int userPoint = 0;
}

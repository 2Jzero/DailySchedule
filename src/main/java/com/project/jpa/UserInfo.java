package com.project.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


// <테이블과 매핑되는 엔티티 클래스, primary key의 타입>
@Repository
public interface UserInfo  extends JpaRepository<UserJPA, Integer> {

    // 사용자의 포인트 값 갱신
    @Modifying
    @Query("update UserJPA u set u.userPoint = :point where u.userId = :userId")
    public int updatePoint(@Param("userId") String userId, @Param("point") int point);

    // 전체 total_point 값
    @Query(value = "select user_point from user where user_id = :userId", nativeQuery = true)
    public int userPoint(@Param("userId") String userId);

    // userJPA userNum 필드의 최대값을 조회하는 커스텀 쿼리 메서드(JPQL 쿼리)
    @Query("select COALESCE(MAX(u.userNum), 0) from UserJPA u")
    public int userJPAMaxNumber();
}

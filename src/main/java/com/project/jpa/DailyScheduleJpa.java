package com.project.jpa;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

// <테이블과 매핑되는 엔티티 클래스, primary key의 타입>
@Repository
public interface DailyScheduleJpa  extends JpaRepository<DailyJPA, Integer> {

    // db의 스케줄 리스트 화면에 보여줌
    @Query(value = "select ds_sq, ds_no, ds_title, ds_ox, ds_owner, ds_point from daily_schedule where ds_owner = :userId",  nativeQuery = true)
    public List<DailyJPA> dailyList(@Param("userId") String userId);

    // number 필드의 최대값을 조회하는 커스텀 쿼리 메서드(JPQL 쿼리)
    @Query("select COALESCE(MAX(d.number), 0) from DailyJPA d")
    public int dailyJPAMaxNumber();

    // 해당 리스트 삭제구현
    @Modifying
    @Query("delete from DailyJPA d where d.sq = :sq")
    public int deleteSchedule(@Param("sq") int sq);

    // 해당 미션의 owner에 따른 미션 완료 표기 변환 ( x -> o )
    @Modifying
    @Query("update DailyJPA d set d.ox = 'O' where d.owner = :userId and d.sq = :sq")
    public int successMission(@Param("userId") String userId, @Param("sq") int sq);

}

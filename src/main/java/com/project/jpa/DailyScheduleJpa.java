package com.project.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// <테이블과 매핑되는 엔티티 클래스, primary key의 타입>
@Repository
public interface DailyScheduleJpa  extends JpaRepository<DailyJPA, Integer> {

    @Query(value = "select ds_sq, ds_no, ds_title, ds_ox, ds_owner, ds_point from daily_schedule",  nativeQuery = true)
    public List<DailyJPA> dailyList();

    // number 필드의 최대값을 조회하는 커스텀 쿼리 메서드(JPQL 쿼리)
    @Query("select COALESCE(MAX(d.number), 0) from DailyJPA d")
    public int findMaxNumber();
}

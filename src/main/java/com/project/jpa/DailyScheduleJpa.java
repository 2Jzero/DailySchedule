package com.project.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// <테이블과 매핑되는 엔티티 클래스, primary key의 타입>
public interface DailyScheduleJpa  extends JpaRepository<DailyJPA, Integer> {

    @Query(value = "select ds_sq, ds_no, ds_title, ds_ox, ds_owner, ds_point from daily_schedule",  nativeQuery = true)
    public List<DailyJPA> dailyList();
}

package com.project.service;

import com.project.jpa.DailyJPA;
import com.project.jpa.DailyScheduleJpa;
import com.project.jpa.UserInfo;
import com.project.jpa.UserJPA;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final DailyScheduleJpa dailyScheduleJpa;

    @Autowired
    public ScheduleService(DailyScheduleJpa dailyScheduleJpa) {
        this.dailyScheduleJpa = dailyScheduleJpa;
    }

    public List<DailyJPA> dailyList() {
        return dailyScheduleJpa.dailyList();
    }

    public DailyJPA insertSchedule(DailyJPA dailyJPA) {

        String subOwner = "폼폼";
        dailyJPA.setOwner(subOwner);

        int maxNumber = dailyScheduleJpa.dailyJPAMaxNumber();
        dailyJPA.setNumber(maxNumber + 1);

        return dailyScheduleJpa.save(dailyJPA);
    }

    @Transactional   // 데이터 수정작업에는 트랜잭션이 필요.
    public int deleteSchedule(int sq) {

        return dailyScheduleJpa.deleteSchedule(sq);
    }


}

package com.project.controller;

import com.project.jpa.DailyJPA;
import com.project.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    private final ScheduleService scheduleService;

    @Autowired
    public MainController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/dsmemo")
    public String mainpage(Model model) {

        // 모델에 데이터 추가 (예: List<DailyJPA> missions)
        List<DailyJPA> dailyList = scheduleService.dailyList();
        model.addAttribute("dailyList", dailyList);

        return "dsmemo";
    }


    @PostMapping("/addSchedule")
    public ResponseEntity<DailyJPA> addSchedule(@ModelAttribute DailyJPA dailyJPA) {

        DailyJPA insertSchedule = scheduleService.insertSchedule(dailyJPA);

        return ResponseEntity.ok(insertSchedule);
    }
}

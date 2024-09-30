package com.project.controller;

import com.project.jpa.DailyJPA;
import com.project.jpa.UserJPA;
import com.project.service.ScheduleService;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class MainController {

    private final ScheduleService scheduleService;

    private final UserService userService;

    @Autowired
    public MainController(ScheduleService scheduleService, UserService userService) {
        this.scheduleService = scheduleService;
        this.userService = userService;
    }


    @GetMapping("/dsmemo")
    public String mainpage(Model model) {

        // 모델에 데이터 추가 (예: List<DailyJPA> missions)
        List<DailyJPA> dailyList = scheduleService.dailyList();

        String userId = "pompom";

        int userPoint = userService.userPoint(userId);

        model.addAttribute("dailyList", dailyList);
        model.addAttribute("userPoint", userPoint);

        return "dsmemo";
    }


    @PostMapping("/addSchedule")
    public ResponseEntity<DailyJPA> addSchedule(@RequestBody DailyJPA dailyJPA) {

        DailyJPA insertSchedule = scheduleService.insertSchedule(dailyJPA);

        return ResponseEntity.ok(insertSchedule);
    }

    @PostMapping("/successSchedule")
    public ResponseEntity<Integer> successSchedule(@RequestParam("point") int point) {

        String userId = "pompom";

        // 미션 점수를 내 계정 점수에 적립하는 코드
        int currentPoint = userService.userPoint(userId);

        int totalPoint = currentPoint + point;

        int updatePoint = userService.updatePoint(userId, totalPoint);

        // ds_ox를 o로 바꿔서 완료되었음을 나타냄

        return ResponseEntity.ok().build();
    }

    @PostMapping("/deleteSchedule")
    public ResponseEntity<Integer> deleteSchedule(@RequestBody int sq) {

        int deleteSchedule = scheduleService.deleteSchedule(sq);

        return ResponseEntity.ok(deleteSchedule);
    }

    @PostMapping("/sign")
    public ResponseEntity<UserJPA> sign(@RequestBody UserJPA userJPA) {

        UserJPA signUser = userService.sign(userJPA);

        return ResponseEntity.ok(signUser);
    }
}

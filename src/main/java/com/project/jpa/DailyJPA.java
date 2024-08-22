package com.project.jpa;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "daily_schedule")
@Getter // Builder 이용하여 객체 생성
@Builder // AllArgsConstructor, NoArgsConstructor 같이 이용해야 컴파일 에러 발생 안함
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class DailyJPA {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    @Column(name = "ds_sq") // 컬럼 정의
    private int sq;

    // 일일 미션 번호
    @Column(name = "ds_no")
    private int number;

    // 일일 미션 제목(내용)
    @Column(length = 100, name = "ds_title")
    private String title;

    // 일일 미션 완료 여부
    @Column(length = 100, name = "ds_ox", columnDefinition = "varchar(2) default 'x'")
    private String ox;

    // 일일 미션 사용자
    @Column(length = 12, name = "ds_owner")
    private String owner;

    // 일일 미션 포인트
    @Column(name = "ds_point", columnDefinition = "int default 20") // columnDefinition = 기본값
    private int point;
}

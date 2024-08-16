package com.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "daily_schedule")
@Getter
@Setter
public class DailyTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ds_sq")
    private int sq;

    @Column(name = "ds_no")
    private int number;

    @Column(name = "ds_title")
    private String title;

    @Column(name = "ds_ox")
    private String ox;

    @Column(name = "ds_point")
    private int point;
}

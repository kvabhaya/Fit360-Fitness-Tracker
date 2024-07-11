package com.devstack.FitnessTrackerServer.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ActivityDto {
    private Long id;
    private Date date;
    private int steps;
    private double distance;
    private int caloriesBurned;
}

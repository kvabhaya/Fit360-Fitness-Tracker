package com.devstack.FitnessTrackerServer.Entity;

import com.devstack.FitnessTrackerServer.dto.ActivityDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private int steps;
    private double distance;
    private int caloriesBurned;

    public ActivityDto getActivityDto() {
        ActivityDto activityDto = new ActivityDto();

        activityDto.setId(id);
        activityDto.setDate(date);
        activityDto.setDistance(distance);
        activityDto.setSteps(steps);
        activityDto.setCaloriesBurned(caloriesBurned);

        return activityDto;
    }
}

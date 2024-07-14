package com.devstack.FitnessTrackerServer.services.activity;

import com.devstack.FitnessTrackerServer.Entity.Activity;
import com.devstack.FitnessTrackerServer.Repository.ActivityRepository;
import com.devstack.FitnessTrackerServer.dto.ActivityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService{
    private final ActivityRepository activityRepository;

    public ActivityDto postActivity(ActivityDto dto){
        Activity activity = new Activity();

        activity.setDate(dto.getDate());
        activity.setSteps(dto.getSteps());
        activity.setDistance(dto.getDistance());
        activity.setCaloriesBurned(dto.getCaloriesBurned());

        return activityRepository.save(activity).getActivityDto();
    }

    public List<ActivityDto> getActivities(){
        List<Activity> activities = activityRepository.findAll();
        return activities.stream().map(Activity::getActivityDto).collect(Collectors.toList());
    }
}

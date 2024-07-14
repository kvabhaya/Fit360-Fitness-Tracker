package com.devstack.FitnessTrackerServer.services.activity;

import com.devstack.FitnessTrackerServer.dto.ActivityDto;

import java.util.List;

public interface ActivityService {

    ActivityDto postActivity(ActivityDto dto);
    List<ActivityDto> getActivities();
}

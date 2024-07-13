package com.devstack.FitnessTrackerServer.services.activity;

import com.devstack.FitnessTrackerServer.dto.ActivityDto;

public interface ActivityService {

    ActivityDto postActivity(ActivityDto dto);
}

package com.devstack.FitnessTrackerServer.controller;

import com.devstack.FitnessTrackerServer.dto.ActivityDto;
import com.devstack.FitnessTrackerServer.services.activity.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping("/activity")
    public ResponseEntity<?> postActivity(@RequestBody ActivityDto dto){
        ActivityDto createActivity = activityService.postActivity(dto);

        if(createActivity != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createActivity);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong..");
        }
    }
}

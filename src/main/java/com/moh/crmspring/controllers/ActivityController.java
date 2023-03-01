package com.moh.crmspring.controllers;

import com.moh.crmspring.entities.Activity;
import com.moh.crmspring.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("activities")
public class ActivityController {
    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<Activity> getAllActivities() {
        return activityService.findAll();
    }

    @GetMapping("{id}")
    public Activity getActivity(@PathVariable Long id) {
        return activityService.findById(id);
    }

    @PostMapping
    public Activity addActivity(@Valid @RequestBody Activity activity) {
        return activityService.save(activity);
    }

    @PutMapping
    public Activity updateActivity(@Valid @RequestBody Activity activity) {
        return activityService.save(activity);
    }

    @DeleteMapping("{id}")
    public void deleteActivity(@PathVariable Long id) {
        Activity activity = activityService.findById(id);
        if (activity != null) {
            activityService.delete(activity);
        }
    }
}

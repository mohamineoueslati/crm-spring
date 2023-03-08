package com.moh.crmspring.controllers;

import com.moh.crmspring.dto.ActivityRequest;
import com.moh.crmspring.dto.ActivityResponse;
import com.moh.crmspring.entities.Activity;
import com.moh.crmspring.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("activities")
public class ActivityController {
    private final ActivityService activityService;
    private final ConversionService conversionService;

    @Autowired
    public ActivityController(ActivityService activityService, ConversionService conversionService) {
        this.activityService = activityService;
        this.conversionService = conversionService;
    }

    @GetMapping
    public List<ActivityResponse> getAllActivities() {
        return activityService.findAll().stream()
                .map(activity ->  conversionService.convert(activity, ActivityResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ActivityResponse getActivity(@PathVariable Long id) {
        return conversionService.convert(activityService.findById(id), ActivityResponse.class);
    }

    @PostMapping
    public ActivityResponse addActivity(@Valid @RequestBody ActivityRequest activityRequest) {
        Activity activity = conversionService.convert(activityRequest, Activity.class);
        return conversionService.convert(activityService.save(activity), ActivityResponse.class);
    }

    @PutMapping
    public ActivityResponse updateActivity(@Valid @RequestBody ActivityRequest activityRequest) {
        Activity activity = conversionService.convert(activityRequest, Activity.class);
        return conversionService.convert(activityService.save(activity), ActivityResponse.class);
    }

    @DeleteMapping("{id}")
    public void deleteActivity(@PathVariable Long id) {
        Activity activity = activityService.findById(id);
        if (activity != null) {
            activityService.delete(activity);
        }
    }
}

package com.moh.crmspring.controllers;

import com.moh.crmspring.dto.ActivityRequest;
import com.moh.crmspring.dto.ActivityResponse;
import com.moh.crmspring.entities.Activity;
import com.moh.crmspring.entities.Contact;
import com.moh.crmspring.services.ActivityService;
import com.moh.crmspring.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("activities")
public class ActivityController {
    private final ActivityService activityService;
    private final ContactService contactService;

    @Autowired
    public ActivityController(ActivityService activityService, ContactService contactService) {
        this.activityService = activityService;
        this.contactService = contactService;
    }

    @GetMapping
    public List<ActivityResponse> getAllActivities() {
        return activityService.findAll().stream().map(ActivityResponse::new).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ActivityResponse getActivity(@PathVariable Long id) {
        return new ActivityResponse(activityService.findById(id));
    }

    @PostMapping
    public ActivityResponse addActivity(@Valid @RequestBody ActivityRequest activityRequest) {
        Activity activity = activityRequestToActivity(activityRequest);
        return new ActivityResponse(activityService.save(activity));
    }

    @PutMapping
    public ActivityResponse updateActivity(@Valid @RequestBody ActivityRequest activityRequest) {
        Activity activity = activityRequestToActivity(activityRequest);
        return new ActivityResponse(activityService.save(activity));
    }

    @DeleteMapping("{id}")
    public void deleteActivity(@PathVariable Long id) {
        Activity activity = activityService.findById(id);
        if (activity != null) {
            activityService.delete(activity);
        }
    }

    private Activity activityRequestToActivity(ActivityRequest activityRequest) {
        Set<Contact> participants = new HashSet<>();
        if (activityRequest.getParticipantsIds() != null)
            participants = new HashSet<>(contactService.findAllByIds(activityRequest.getParticipantsIds()));

        Activity activity = new Activity(activityRequest);
        activity.setParticipants(participants);

        return activity;
    }
}

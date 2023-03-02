package com.moh.crmspring.controllers;

import com.moh.crmspring.dto.ActivityDto;
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
    public List<ActivityDto> getAllActivities() {
        return activityService.findAll().stream().map(ActivityDto::new).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ActivityDto getActivity(@PathVariable Long id) {
        return new ActivityDto(activityService.findById(id));
    }

    @PostMapping
    public ActivityDto addActivity(@Valid @RequestBody ActivityDto activityDto) {
        Activity activity = activityDtoToActivity(activityDto);
        return new ActivityDto(activityService.save(activity));
    }

    @PutMapping
    public ActivityDto updateActivity(@Valid @RequestBody ActivityDto activityDto) {
        Activity activity = activityDtoToActivity(activityDto);
        return new ActivityDto(activityService.save(activity));
    }

    @DeleteMapping("{id}")
    public void deleteActivity(@PathVariable Long id) {
        Activity activity = activityService.findById(id);
        if (activity != null) {
            activityService.delete(activity);
        }
    }

    private Activity activityDtoToActivity(ActivityDto activityDto) {
        Set<Contact> participants = new HashSet<>();
        if (activityDto.getParticipantsIds() != null)
            participants = new HashSet<>(contactService.findAllByIds(activityDto.getParticipantsIds()));

        Activity activity = new Activity(activityDto);
        activity.setParticipants(participants);

        return activity;
    }
}

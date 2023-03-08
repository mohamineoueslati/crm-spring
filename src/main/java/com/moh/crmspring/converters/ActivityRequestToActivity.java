package com.moh.crmspring.converters;

import com.moh.crmspring.dto.ActivityRequest;
import com.moh.crmspring.entities.Activity;
import com.moh.crmspring.entities.Contact;
import com.moh.crmspring.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

public class ActivityRequestToActivity implements Converter<ActivityRequest, Activity> {
    private ContactService contactService;

    @Autowired
    @Lazy
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @Override
    public Activity convert(ActivityRequest activityRequest) {
        Set<Contact> participants = new HashSet<>();
        if (activityRequest.getParticipantsIds() != null)
            participants = new HashSet<>(contactService.findAllByIds(activityRequest.getParticipantsIds()));

        Activity activity = new Activity(activityRequest);
        activity.setParticipants(participants);

        return activity;
    }
}

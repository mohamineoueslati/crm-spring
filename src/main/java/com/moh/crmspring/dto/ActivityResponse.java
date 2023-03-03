package com.moh.crmspring.dto;

import com.moh.crmspring.entities.Activity;

import java.util.Set;
import java.util.stream.Collectors;

public class ActivityResponse extends ActivityDto {
    private Set<ContactResponse> participants;

    public ActivityResponse() {
    }

    public ActivityResponse(Activity activity) {
        super(activity);
        this.participants = activity.getParticipants() != null
                ? activity.getParticipants().stream().map(ContactResponse::new).collect(Collectors.toSet())
                : null;
    }

    public Set<ContactResponse> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<ContactResponse> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return super.toString() + "ActivityResponse{" +
                "participants=" + participants +
                '}';
    }
}

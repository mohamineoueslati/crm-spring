package com.moh.crmspring.dto;

import java.util.Set;

public class ActivityRequest extends ActivityDto {
    protected Set<Long> participantsIds;

    public ActivityRequest() {}

    public Set<Long> getParticipantsIds() {
        return participantsIds;
    }

    public void setParticipantsIds(Set<Long> participantsIds) {
        this.participantsIds = participantsIds;
    }

    @Override
    public String toString() {
        return super.toString() + "ActivityRequest{" +
                "participantsIds=" + participantsIds +
                '}';
    }
}

package com.moh.crmspring.dto;

import com.moh.crmspring.entities.Activity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ActivityDto implements Serializable {
    private Long id;
    @NotNull
    private Date date;
    @NotNull
    private Activity.ActivityType activityType;
    private String subject;
    private String note;
    private Set<Long> participantsIds;

    public ActivityDto() {
    }

    public ActivityDto(Activity activity) {
        this.id = activity.getId();
        this.date = activity.getDate();
        this.activityType = activity.getActivityType();
        this.subject = activity.getSubject();
        this.note = activity.getNote();
        this.participantsIds = new HashSet<>();
        activity.getParticipants().forEach(p -> participantsIds.add(p.getId()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Activity.ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(Activity.ActivityType activityType) {
        this.activityType = activityType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<Long> getParticipantsIds() {
        return participantsIds;
    }

    public void setParticipantsIds(Set<Long> participantsIds) {
        this.participantsIds = participantsIds;
    }

    @Override
    public String toString() {
        return "ActivityDto{" +
                "id=" + id +
                ", date=" + date +
                ", activityType=" + activityType +
                ", subject='" + subject + '\'' +
                ", note='" + note + '\'' +
                ", participantsIds=" + participantsIds +
                '}';
    }
}

package com.moh.crmspring.dto;

import com.moh.crmspring.entities.Activity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public abstract class ActivityDto implements Serializable {
    protected Long id;
    @NotNull
    protected Date date;
    @NotNull
    protected Activity.ActivityType activityType;
    protected String subject;
    protected String note;

    public ActivityDto() {
    }

    public ActivityDto(Activity activity) {
        this.id = activity.getId();
        this.date = activity.getDate();
        this.activityType = activity.getActivityType();
        this.subject = activity.getSubject();
        this.note = activity.getNote();
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

    @Override
    public String toString() {
        return "ActivityDto{" +
                "id=" + id +
                ", date=" + date +
                ", activityType=" + activityType +
                ", subject='" + subject + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}

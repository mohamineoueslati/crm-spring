package com.moh.crmspring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "activity")
public class Activity implements Serializable {
    public enum ActivityType {
        APPEL, DINER, EMAIL, COMITE_DE_GESTION, REUNION, NOTE
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "activity_type", nullable = false)
    private ActivityType activityType;

    @Column(name = "subject")
    private String subject;

    @Column(name = "note")
    private String note;

    @ManyToMany
    @JoinTable(
            name = "activity_contact",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id")
    )
    private Set<Contact> participants;

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

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
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

    public Set<Contact> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Contact> participants) {
        this.participants = participants;
    }

    public boolean addParticipant(Contact contact) {
        if (participants == null) {
            participants = new HashSet<>();
        }

        return participants.add(contact);
    }

    public void removeParticipant(Contact contact) {
        participants.remove(contact);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", date=" + date +
                ", activityType=" + activityType +
                ", subject='" + subject + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}

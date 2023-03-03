package com.moh.crmspring.dto;

import com.moh.crmspring.entities.Contact;

import java.util.HashSet;
import java.util.Set;

public class ContactResponse extends ContactDto {
    private ContactResponse contactOwner;
    private Set<Long> activitiesIds;

    public ContactResponse() {
    }

    public ContactResponse(Contact contact) {
        super(contact);
        this.contactOwner = contact.getContactOwner() != null ? new ContactResponse(contact.getContactOwner()) : null;
        this.activitiesIds = new HashSet<>();
        if (contact.getActivities() != null) {
            contact.getActivities().forEach(a -> activitiesIds.add(a.getId()));
        }
    }

    public ContactResponse getContactOwner() {
        return contactOwner;
    }

    public void setContactOwner(ContactResponse contactOwner) {
        this.contactOwner = contactOwner;
    }

    public Set<Long> getActivitiesIds() {
        return activitiesIds;
    }

    public void setActivitiesIds(Set<Long> activitiesIds) {
        this.activitiesIds = activitiesIds;
    }

    @Override
    public String toString() {
        return super.toString() + "ContactResponse{" +
                "contactOwner=" + contactOwner +
                '}';
    }
}

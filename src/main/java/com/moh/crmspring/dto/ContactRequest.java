package com.moh.crmspring.dto;

public class ContactRequest extends ContactDto {
    private Long contactOwnerId;

    public ContactRequest() {
    }

    public Long getContactOwnerId() {
        return contactOwnerId;
    }

    public void setContactOwnerId(Long contactOwnerId) {
        this.contactOwnerId = contactOwnerId;
    }

    @Override
    public String toString() {
        return super.toString() + "ContactRequest{" +
                "contactOwnerId=" + contactOwnerId +
                '}';
    }
}

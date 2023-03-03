package com.moh.crmspring.dto;

import com.moh.crmspring.entities.Contact;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public abstract class ContactDto implements Serializable {
    protected Long id;
    @NotEmpty
    protected String firstName;
    @NotEmpty
    protected String lastName;
    @Email
    protected String email;
    protected String phone;
    protected String company;
    protected Contact.JobTitle jobTitle;
    protected AddressDto address;

    public ContactDto() {
    }

    public ContactDto(Contact contact) {
        this.id = contact.getId();
        this.firstName = contact.getFirstName();
        this.lastName = contact.getLastName();
        this.email = contact.getEmail();
        this.phone = contact.getPhone();
        this.company = contact.getCompany();
        this.jobTitle = contact.getJobTitle();
        this.address = contact.getAddress() != null ? new AddressDto(contact.getAddress()) : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public Contact.JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(Contact.JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "ContactDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                ", address=" + address +
                '}';
    }
}

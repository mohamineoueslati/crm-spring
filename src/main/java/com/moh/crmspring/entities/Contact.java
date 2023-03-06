package com.moh.crmspring.entities;

import com.moh.crmspring.dto.ContactRequest;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contact")
public class Contact {
    public enum JobTitle {
        CEO, SOFTWARE_ENGINEER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "company")
    private String company;

    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;

    @ManyToOne
    @JoinColumn(name = "contact_owner_id")
    private Contact contactOwner;

    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "activity_contact",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private Set<Activity> activities;

    public Contact() {
    }

    public Contact(ContactRequest contactRequest) {
        this.id = contactRequest.getId();
        this.firstName = contactRequest.getFirstName();
        this.lastName = contactRequest.getLastName();
        this.email = contactRequest.getEmail();
        this.phone = contactRequest.getPhone();
        this.company = contactRequest.getCompany();
        this.jobTitle = contactRequest.getJobTitle();
        this.address = contactRequest.getAddress() != null ? new Address(contactRequest.getAddress()) : null;
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

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Contact getContactOwner() {
        return contactOwner;
    }

    public void setContactOwner(Contact contactOwner) {
        this.contactOwner = contactOwner;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "Id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                ", jobTitle=" + jobTitle +
                ", address=" + address +
                '}';
    }
}

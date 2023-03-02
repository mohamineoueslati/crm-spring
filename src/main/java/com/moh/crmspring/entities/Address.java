package com.moh.crmspring.entities;

import com.moh.crmspring.dto.AddressDto;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    public enum Country {
        TUNISIA, ALGERIA, MOROCCO
    }

    @Id
    @Column(name = "contact_id")
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private Integer zipCode;

    @OneToOne
    @MapsId
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Address() {}

    public  Address(AddressDto addressDto) {
        this.id = addressDto.getId();
        this.address = addressDto.getAddress();
        this.city = addressDto.getCity();
        this.state = addressDto.getState();
        this.country = addressDto.getCountry();
        this.zipCode = addressDto.getZipCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}

package com.moh.crmspring.dto;

import com.moh.crmspring.entities.Address;

import java.io.Serializable;

public class AddressDto implements Serializable {
    private Long id;
    private String address;
    private String city;
    private Address.Country country;
    private String state;
    private Integer zipCode;

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

    public Address.Country getCountry() {
        return country;
    }

    public void setCountry(Address.Country country) {
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
}
